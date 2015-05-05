/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4;
// Producteurs-Consommateurs : Classe Consommateur
//
public class Consommateur implements Runnable {
  // Le numero associe au consommateur (pour le reperer)	  
  private int monNum;
  // Le moniteur gerant l'acces synchronise au buffer dans lequel il depose (partage avec tous les autres)
  private MoniteurBuffer monBuffer;
  // Eventuels autres attributs
  // . . 

  // Constructeur de la classe
  public Consommateur (MoniteurBuffer leBuffer, int numConso) {
    // A completer
    // . . . 
    System.out.println("Consommateur (" + monNum + ") : defini");
  }

  // Eventuelles fonctions locales utiles
  // . . . 

	  
  // Implantation de run => comportement du consommateur
  public void run() {
    // Preparer son message (a vide)
    Message monMessage = new Message(monNum, monNum, -1);
   
    // Lire des messages (modifier pour terminer l'application proprement)
    int cpt = 0;
    while (true) {
      cpt++;
	      
      // Retirer un message du buffer (appel au moniteur)
      try {
          System.out.println("Consommateur (" + monNum + ") de type " + monType + ": je veux retirer");
	  monBuffer.retirer(monMessage);
      } catch (InterruptedException e1) {
	  e1.printStackTrace();
      }
	      
      System.out.print("Consommateur (" + monNum + ") : Tour " + cpt + ", je retire ");
      monMessage.afficherMessage();
      System.out.println();

      // Temporiser un peu 
      try {
	  Thread.sleep(1000 * (((int)Math.random() * 3) + 1));
          Thread.sleep(100); // 100 ms
      } // Recuperer l'eventuelle exception
      catch (InterruptedException e) {
        e.printStackTrace();
      }  
    } // while (true)
    System.out.println("Consommateur (" + monNum + ") : termine");
  } // run
}

