/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;
// Joueur dans le jeu de ping pong avec synchronisation via un "moniteur" Table

import java.util.logging.Level;
import java.util.logging.Logger;


public class Joueur implements Runnable {

    // Lee type de coup joue
    private int monType;
    // Le numero associe au joueur
    private int monNum;
    // Le "moniteur" gerant l'acces des joueurs a la table commune
    private MoniteurTable maTable;

    public final static int PONG = 0;
    public final static int PING = 1;

    // Constructeur de la classe joueur
    public Joueur(int numJoueur, int typeJoueur, MoniteurTable uneTable) {
        monType = typeJoueur;
        monNum = numJoueur;
        maTable = uneTable;
        System.out.println("Joueur " + monNum + " (" + monType + ") : defini");
    }

    // Implantation de run => comportement du joueur
    public void run() {
        int i;
        for (i = 0; i < 10; i++) {
            try {
                maTable.demanderAccesTable(this.monType);
            
                System.out.println("Joueur " + monNum + " (de type " + monType + ") : je joue pour la " + i + "me fois");
                
                maTable.libererAccesTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Joueur " + monNum + " (de type " + monType + ") : termine");
    }
}
