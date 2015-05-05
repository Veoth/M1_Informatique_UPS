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

typedef struct{
    int compteur;
    float reel;
}data_shm;

data_shm *ptshm;

void fils(int nombre)
{	
	int i;
	ptshm->reel =10.0;

	for (i=0;i<nombre;i++)
	{
		ptshm->compteur++;
		
	}
	 
}

void pere(int nombre)
{
	int i;
	for (i=0;i<nombre;i++)
	{
		ptshm->compteur--;
	}
	printf("\nReelle : %f\n", ptshm->reel);
}

int main(int argc, char *argv[])
{
	int nombre, shmid;
	if (argc != 2)
	{
		perror("Erreur 1\n");
		exit(7);
	}

	nombre = atoi(argv[1]);
	key_t key;
	
	// Id externe
	// Pour avoir le meme segment de donnee il suffit de renseigner les deux même parametre.
	if ((key = ftok("variante3.c", 8)) == -1)
	{
		perror("Erreur 2\n");
		exit(1);
	}	
	
	// Création d'un segment de mémoire partagé.
	if ((shmid = shmget(key, sizeof(data_shm), IPC_CREAT | 0777)) == -1)
	{
		perror("Erreur 3\n");
		exit(2);
	}	

	// Attacher le segment
	if ((ptshm = shmat(shmid, NULL, 0)) == (void*)-1)
	{
		perror("Erreur 4\n");
		exit(3);
	}
	
	ptshm->compteur = 0;

	// Fork après shmat est attaché au segment de donnée comme le père. Il faut donc le detacher.
	// Si avant shat, il faut l'attacher.
	pid_t pid = fork();

	switch (pid)
	{
		case -1:
			perror("Erreur 5\n");
			exit(EXIT_FAILURE);			
		case 0:
			fils(nombre);

			// Detacher le segment
			if (shmdt(ptshm) == -1)
			{
				perror("Erreur 6\n");
				exit(4);
			}	
			exit(0);
	}
	
	pere(nombre);
	wait(NULL);
	printf("Compteur : %d\n", ptshm->compteur);

	// Detacher le segment
	if (shmdt(ptshm) == -1)
	{
		perror("Erreur 7\n");
		exit(4);
	}

	// Destruction du segment
	if (shmctl(shmid, IPC_RMID, NULL) == -1)
	{
		perror("Erreur 8\n");
		exit(5);
	}

	return EXIT_SUCCESS;
}


