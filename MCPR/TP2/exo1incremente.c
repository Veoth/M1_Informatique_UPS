#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

#define MUTEX 0
#define BAR 1

/* Observations
Segment de mémoire partagé sont accessible à différent processus.
Persistant sur un système, nombre limité.
Les détruire avant d'éteindre la machine.
*/

union semun
{
	int val;
	struct semid_ds *buf;
	short *array;
}arg;

struct sembuf op;

typedef struct{
    int compteur;
    float reel;
}data_shm;

data_shm *ptshm;

void pere(int nombre, int semid)
{
	int i;
	
	for (i=0;i<nombre;i++)
	{
		// Section critique
		op.sem_num = MUTEX;
		op.sem_op = -1;
		op.sem_flg = 0;

		if (semop(semid,&op,1)==-1 )
		{
			perror("Erreur 10\n");
			exit(1);
		}

		ptshm->compteur++;
		printf("compteur : %d\n",ptshm->compteur);

		op.sem_num = MUTEX;
		op.sem_op = 1;
		op.sem_flg = 0;

		if (semop(semid,&op,1)==-1 )
		{
			perror("Erreur 10\n");
			exit(1);
		}

	}

	printf("val = %f\n", ptshm->reel);
}

int main(int argc, char *argv[])
{
	key_t key;
	int nombre, shmid;
	int semid;
	unsigned short init[] = {1,0};
	
	nombre = atoi(argv[1]);
	
	if ((key = ftok("exo1decremente.c", 10)) == -1)
	{
		perror("Erreur 1\n");
		exit(1);
	}

	// Récupération ensemble de sémaphore
	if ((semid = semget(key, 0, 0)) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}

	// Recupération de la mémoire partagé.
	if ((shmid = shmget(key, 0, 0))== -1) 
	{
		perror("Erreur 3\n");
		exit(1);
	}

	// Attacher le segment
	if ((ptshm = shmat(shmid, NULL, 0)) == (void*)-1)
	{
		perror("Erreur 4\n");
		exit(3);
	}

	pere(nombre, semid);

	// On peut detruire
	op.sem_num = BAR;
	op.sem_op = 1;
	op.sem_flg = 0;
	
	if (semop(semid, &op, 1) == -1 )
	{
		perror("Erreur 10\n");
		exit(1);
	}
	// Detacher le segment
	if (shmdt(ptshm) == -1)
	{
		perror("Erreur 5\n");
		exit(4);
	}

	return EXIT_SUCCESS;
}


