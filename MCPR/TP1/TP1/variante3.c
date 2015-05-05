#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>


/* Observations
Segment de mémoire partagé sont accessible à différent processus.
Persistant sur un système, nombre limité.
Les détruire avant d'éteindre la machine.
*/
int compteur = 0;

void fils(int nombre, int *ptshm)
{	
	int i;
	for (i=0;i<nombre;i++)
	{
		(*ptshm)++;
		//printf("Incrementation fils : %d\n", *ptshm);
	}
	//printf("Compteur fils : %d\n", *ptshm);
}

void pere(int nombre, int *ptshm)
{
	int i;
	for (i=0;i<nombre;i++)
	{
		(*ptshm)--;
		//printf("Decrementation pere : %d\n", *ptshm);
	}
	//printf("Compteur pere : %d\n", *ptshm);
}

int main(int argc, char *argv[])
{
	int nombre, shmid, *ptshm;
	if (argc != 2)
	{
		perror("Erreur\n");
		exit(7);
	}

	nombre = atoi(argv[1]);
	key_t key;
	
	// Id externe
	// Pour avoir le meme segment de donnee il suffit de renseigner les deux même parametre.
	if ((key = ftok("variante3.c", 8)) == -1)
	{
		perror("Erreur\n");
		exit(1);
	}	
	
	// Création d'un segment de mémoire partagé.
	if ((shmid = shmget(key, sizeof(int), IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur\n");
		exit(2);
	}	

	// Attacher le segment
	if ((ptshm = shmat(shmid, NULL, 0)) == (void*)-1)
	{
		perror("Erreur\n");
		exit(3);
	}
	
	*ptshm = 0;

	// Fork après shmat est attaché au segment de donnée comme le père. Il faut donc le detacher.
	// Si avant shat, il faut l'attacher.
	pid_t pid = fork();

	switch (pid)
	{
		case -1:
			perror("Erreur\n");
			exit(EXIT_FAILURE);			
		case 0:
			fils(nombre, ptshm);

			// Detacher le segment
			if (shmdt(ptshm) == -1)
			{
				perror("Erreur\n");
				exit(4);
			}	
			exit(0);
	}

	pere(nombre, ptshm);
	wait(NULL);
	printf("Compteur pere : %d\n", *ptshm);

	// Detacher le segment
	if (shmdt(ptshm) == -1)
	{
		perror("Erreur\n");
		exit(4);
	}

	// Destruction du segment
	if (shmctl(shmid, IPC_RMID, NULL) == -1)
	{
		perror("Erreur\n");
		exit(5);
	}

	return EXIT_SUCCESS;
}


