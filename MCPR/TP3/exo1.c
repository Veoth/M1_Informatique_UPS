#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

#define N 10
#define S_CASE_VIDE 0
#define S_CASE_PLEINE 1
#define S_MUTEX_INSERER 2
#define S_MUTEX_RECU 3

/* Observations
Segment de mémoire partagé sont accessible à différent processus.
Persistant sur un système, nombre limité.
Les détruire avant d'éteindre la machine.
*/

union semun
{
	int val;
	struct semid_ds *buf;
	unsigned short *array;
}arg;

typedef int Message;

typedef struct Buffer
{
	Message tab[N];
	int index_conso;
	int index_pro;
}Buffer;

void inserer(Message m, Buffer *b)
{
	b->tab[b->index_pro] = m;
	b->index_pro = (b->index_pro+1)%N;
}	

void extraire(Message *m, Buffer *b)
{
	*m = b->tab[b->index_conso];
	b->index_conso = (b->index_conso+1)%N;			
}

void deposer(Message m, Buffer *b, int semid)
{
	struct sembuf op;
	
	// Il y a la place dans le buffer ?
	op.sem_num = S_CASE_VIDE;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	// Section critique
	op.sem_num = S_MUTEX_INSERER;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	inserer(m, b);

	op.sem_num = S_MUTEX_INSERER;
	op.sem_op = 1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	// Rajout d'un jeton permettant de retirer un message
	op.sem_num = S_CASE_PLEINE;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}
}

void retirer(Message *m, Buffer *b, int semid)
{
	struct sembuf op;

	// Il y a un message dans le buffer ?
	op.sem_num = S_CASE_PLEINE;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	// Section critique
	op.sem_num = S_MUTEX_RECU;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	extraire(m, b);

	op.sem_num = S_MUTEX_RECU;
	op.sem_op = 1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

	// Rejout d'un jeton indiquant qu'il y a un message en moins
	op.sem_num = S_CASE_PLEINE;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1) == -1)
	{
		perror("Erreur P\n");
		exit(1);
	}

}

void consommateur(int i, Buffer *b, int semid)
{
	Message m;
	retirer(&m, b, semid);
	printf("Je suis le consommateur %d et voici le message : %d", i, m);
}

void producteur(int i, Buffer *b, int semid)
{
	Message m = (int)i;
	deposer(m, b, semid);
}

int creationSemaphore(key_t key, int nbSem, unsigned short *init)
{
	int semid;

	if ((key = ftok("exo1.c", 12)) == -1)
	{
		perror("Erreur 1\n");
		exit(1);
	}

	// Création ensemble de sémaphore
	if ((semid = semget(key, nbSem, IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}

	// Initialisation de l'ensemble des sémaphores
	arg.array = init;
	if (semctl(semid, 0, SETALL, arg) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}

	return semid;
}

int creationMemPartage(key_t key, Buffer **b)
{
	int shmid;

	// Création de la mémoire partagé.
	if ((shmid = shmget(key, sizeof(Buffer), IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur 3\n");
		exit(1);
	}

	// Attacher le segment
	if ((*b = shmat(shmid, NULL, 0)) == (void*)-1)
	{
		perror("Erreur 4\n");
		exit(3);
	}
	
	return shmid;
}

void destructionSemaphoreMemoire(int semid, int shmid, Buffer *b)
{
	// Destruction semaphore
	if (semctl(semid, 0, IPC_RMID,0)== -1)
	{
		perror("Erreur sup\n");
		exit(1);
	}

	// Detacher le segment
	if (shmdt(b) == -1)
	{
		perror("Erreur 5\n");
		exit(4);
	}

	// Destruction du segment
	if (shmctl(shmid, IPC_RMID, NULL) == -1)
	{
		perror("Erreur 8\n");
		exit(5);
	}	
}

int main(int argc, char *argv[])
{	
	key_t key;
	int i, j;
	int semid, shmid;
	int nbProd, nbConso;
	

	Buffer *b;
	
	if (argc != 3)
	{
		perror("Nombres d'arguments invalide\n");
		exit(1);
	}

	nbProd = atoi(argv[1]);
	nbConso = atoi(argv[2]);	
	
	/* S_case_vides ; s_cases_pleines ; S_mutex_inserer ; S_mutex_recu */
	unsigned short *init = {10,0,1,1};

	if ((key = ftok("exo1.c", 12)) == -1)
	{
		perror("Erreur 1\n");
		exit(1);
	}

	semid = creationSemaphore(key, 4, init);
	shmid = creationMemPartage(key, &b);
	
	// Initialisation des index
	b->index_pro = 0;
	b->index_conso = 0;

	for (i = 0 ; i<nbProd ; i++)
	{	
		switch(fork())
		{
			case -1:
				perror("Erreur 5\n");
				exit(EXIT_FAILURE);			
			case 0:
				producteur(i, b, semid);
				exit(0);
		}
	}

	for (j = 0 ; j<nbConso ; j++)
	{	
		switch(fork())
		{
			case -1:
				perror("Erreur 5\n");
				exit(EXIT_FAILURE);			
			case 0:
				consommateur(j, b, semid);
				exit(0);
		}
	}

	while (wait(NULL) != -1);

	destructionSemaphoreMemoire(semid, shmid, b);

	return EXIT_SUCCESS;
}


