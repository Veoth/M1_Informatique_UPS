#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

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

void fils(int semid, int numP, int i, int nbProc, int nbBoucle)
{
	struct sembuf op;
	int j;

	for (j = 0 ; j<nbBoucle ; j++)
	{
		// Section critique
		op.sem_num = i;
		op.sem_op = -1;
		op.sem_flg = 0;

		if (semop(semid, &op, 1) == -1)
		{
			perror("Erreur P\n");
			exit(1);
		}

		printf("Affichage du processus : %d\n", numP);

		op.sem_num = (i+1)%nbProc;
		op.sem_op = 1;
		op.sem_flg = 0;

		if (semop(semid,&op,1)==-1 )
		{
			perror("Erreur V\n");
			exit(1);
		}	
	}
}

int main(int argc, char *argv[])
{
	key_t key;
	int nbProc, nbBoucle;
	int semid, i;
	unsigned short *init;
	pid_t pid;
	
	nbProc = atoi(argv[1]);
	nbBoucle = atoi(argv[2]); 

	init = calloc(nbProc, sizeof(unsigned short));
	init[0] = 1;

	if ((key = ftok("alternance.c", 10)) == -1)
	{
		perror("Erreur 1\n");
		exit(1);
	}

	// Création ensemble de sémaphore
	if ((semid = semget(key, nbProc, IPC_CREAT | 0777)) == -1)
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

	for (i = 0 ; i<nbProc ; i++)
	{
		pid = fork();
		
		switch(pid)
		{
			case -1:
				perror("Erreur 5\n");
				exit(EXIT_FAILURE);			
			case 0:
				fils(semid, i, i, nbProc, nbBoucle);
				exit(0);
		}
	}

	while (wait(NULL) != -1);

	// Destruction semaphore
	if (semctl(semid, 0, IPC_RMID,0)== -1)
	{
		perror("Erreur sup\n");
		exit(1);
	}	

	return EXIT_SUCCESS;
}


