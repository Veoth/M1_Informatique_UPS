#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/* Observations
Si 10 décrémentation/incrémentation, alors on a -10 et 10.

*/

void incremente(int nombre)
{	
	int i, compteur = 0;
	for (i=0;i<nombre;i++)
		compteur++;
	printf("Compteur fils : %d\n", compteur);
}

void decremente(int nombre)
{
	int i, compteur = 0;
	for (i=0;i<nombre;i++)
		compteur--;
	printf("Compteur pere : %d\n", compteur);
}

int main(int argc, char *argv[])
{
	int nombre;
	nombre = atoi(argv[1]);
	
	pid_t pid = fork();
	
	switch (pid)
	{
		case -1:
			perror("Erreur\n");
			exit(EXIT_FAILURE);			
		case 0:
			incremente(nombre);
			exit(0);
		default :
			decremente(nombre);
			break;
	}
	wait(NULL);

	return EXIT_SUCCESS;
}


