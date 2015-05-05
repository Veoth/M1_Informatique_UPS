/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;
// Base pour le jeu de ping pong avec synchronisation entre joueurs

// A modifier pour faire jouer un joueur Ping et un joueur Pong
// puis N joueurs Ping et M joueurs Pong
// avec N et M = parametres de l'application
public class BasePingPongSynchro {

    public static final int nbJoueurs = 3;

    public static void main(String[] args) {
        // Creation du "moniteur" gerant les acces synchronises a la table de jeu
        // la meme instance de la classe pour tous les joueurs (sinon, impossible
        // d'avoir de la synchro
        MoniteurTable laTable = new MoniteurTable();
        Joueur comportementJoueurPing[] = new Joueur[nbJoueurs];
        Joueur comportementJoueurPong[] = new Joueur[nbJoueurs];
        Thread joueurPing[] = new Thread[nbJoueurs];
        Thread joueurPong[] = new Thread[nbJoueurs];

        int q = 1;
        for (int i = 0; i < nbJoueurs ; i ++) {
            comportementJoueurPing[i] = new Joueur(q, Joueur.PING, laTable);
            q++;
            comportementJoueurPong[i] = new Joueur(q, Joueur.PONG, laTable);
            q++;
        }

        q = 1;
        for (int i = 0; i < nbJoueurs ; i ++) {
            joueurPing[i] = new Thread(comportementJoueurPing[i]);
            q++;
            joueurPong[i] = new Thread(comportementJoueurPong[i]);
            q++;
        }

        // Lancement des joueurs
        for (int i = 0; i<nbJoueurs ; i++) {
            joueurPing[i].start();
            joueurPong[i].start();
        }
        System.out.println("Fin lancement application BasePingPong_VRunnable");

        System.out.println("Fin application BasePingPong_VRunnable");
    }
}
