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
	unsigned short *array;
}arg;

struct sembuf op;

typedef struct{
    int compteur;
    float reel;
}data_shm;

data_shm *ptshm;

void fils(int nombre, int semid)
{
	int i;

	ptshm->reel = 30.3;

	for (i=0;i<nombre;i++)
	{
		// Section critique
		op.sem_num = MUTEX;
		op.sem_op = -1;
		op.sem_flg = 0;

		if ( semop(semid,&op,1)==-1 )
		{
			perror("Erreur 10\n");
			exit(1);
		}

		ptshm->compteur--;
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

	// Création ensemble de sémaphore
	if ((semid = semget(key, 2, IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}
	

	// Création de la mémoire partagé.
	if ((shmid = shmget(key, sizeof(data_shm), IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur 3\n");
		exit(1);
	}
	
	// Initialisation de l'ensemble des sémaphores
	
	arg.array = init;
	if (semctl(semid, 0, SETALL, arg) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}
	

	// Attacher le segment
	if ((ptshm = shmat(shmid, NULL, 0)) == (void*)-1)
	{
		perror("Erreur 4\n");
		exit(3);
	}

	ptshm->compteur = 0;
	
	fils(nombre, semid);

	op.sem_num = BAR;
	op.sem_op = -1;
	op.sem_flg = 0;

	if (semop(semid, &op, 1 )== -1 ) 
	{ 
		perror("Erreur 9\n");
		exit(4);
	}

	// Detacher le segment
	if (shmdt(ptshm) == -1)
	{
		perror("Erreur 5\n");
		exit(4);
	}

	
	// Destruction semaphore
	if (semctl(semid, 0, IPC_RMID)== -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}	

	// Destruction du segment
	if (shmctl(shmid, IPC_RMID, NULL) == -1)
	{
		perror("Erreur 8\n");
		exit(5);
	}

	return EXIT_SUCCESS;
}


