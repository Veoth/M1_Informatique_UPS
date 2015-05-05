/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;
// Classe jouant le role du moniteur qui protege les acces
// a la table de ping-pong et assure l'alternance des coups
// des joueurs 

// Pour declarer des "variables condition"
import java.util.concurrent.locks.Condition;
// Pour declarer des verrous ou semaphores d'exclusion mutuelle
import java.util.concurrent.locks.ReentrantLock;

public class MoniteurTable {

    // Les types de coups possibles
    public final int PONG = 0;
    public final int PING = 1;

    private final ReentrantLock mutex;
    private final Condition jouer[];
    
    // Variables d'états, permmettant de savoir qui à joué et si la table est occupe
    private int aJoue;
    private Boolean busy;

    // Constructeur de la classe
    public MoniteurTable() {
        mutex = new ReentrantLock();
        jouer = new Condition[2];
        
        // Deux files d'attentes qui vont bloquer les joueurs PING et PONG dans deux files différentes
        jouer[0] = mutex.newCondition();
        jouer[1] = mutex.newCondition();
        
        aJoue = 0; // On considere que PONG (0) vient de jouer
        busy = false;
    }

    // Obtenir l'acces a la table pour pouvoir jouer
    public void demanderAccesTable(int typeJoueur) throws InterruptedException {
        mutex.lock();
        
        try {
            // On attent tant que la table est occupé et si on vient juste de jouer
            while(aJoue == typeJoueur || busy) {
                jouer[typeJoueur].await();
            }
            
            // Le joueur peut maintenant jouer
            busy = true;
            aJoue = typeJoueur;
        } finally {
            mutex.unlock();
        }
    }

    // Rendre l'acces au joueur du type oppose
    public void libererAccesTable() {
        mutex.lock();
        
        // Reveille du joueur adverse
        try {
            jouer[(aJoue+1)%2].signal();
            busy = false;
        } finally {
            mutex.unlock();
        }
    }
}
