/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4;

// Producteurs-Consommateurs : Classe Producteur

public class Producteur implements Runnable {
  // Le numero associe au producteur (pour le reperer)	  
  private int monNum;
  // Le type de message qu'il depose (si necessaire)
  private int monType;
  // Le moniteur gerant l'acces au buffer dans lequel il depose (partage avec tous les autres)
  private MoniteurBuffer monBuffer;
  // Eventuels autres attributs
  // . . 

  // Constructeur de la classe
  public Producteur (MoniteurBuffer leBuffer, int numConso, int unType) {
    // A completer
    // . . . 
    System.out.println("Producteur (" + monNum + ") : defini");
  }

  // Eventuelles fonctions locales utiles
  // . . . 

	  
  // Implantation de run => comportement du producteur
  public void run() {
    for (int i = 0; i < 10; i++) {
      Message monMessage = new Message(i, monNum, monType);
      // Deposer un message dans le buffer (via le moniteur)
      try {
          System.out.println("Producteur (" + monNum + ") de type " + monType + ": je veux deposer");
	  monBuffer.deposer(monMessage);
      } catch (InterruptedException e1) {
	  e1.printStackTrace();
      }
      // Temporiser un peu (pour apprecier la synchro)
      try {
        Thread.sleep(1000 * (((int)Math.random() * 2) + 1));
        Thread.sleep(400); // 400 ms
      }  // Recuperer l'eventuelle exception 
      catch (InterruptedException e) {
          e.printStackTrace();
      } 
    } // for
    System.out.println("Producteur (" + monNum + ") : termine");
  } // run
}

