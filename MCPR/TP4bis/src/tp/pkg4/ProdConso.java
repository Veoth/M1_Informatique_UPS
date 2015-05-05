/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4;
// Producteurs-Consommateurs
// Application lancant P producteurs et C consommateurs
// partageant un buffer de N cases
// C, P et N sont les parametres de l'application
//
public class ProdConso {

  public static void main(String[] args) {
       if (args.length != 3) {
          System.out.println("Usage: NomClasse CapaciteBuffer nbProducteurs nbConsommateurs");
    	  System.exit(1);
       }
       // Creer le "moniteur" gerant la synchronisation de l'application
       Buffer buffer = . . . . 
       
       // Nombre de producteurs parametre du main
       int nbProducteurs = . . . .
       // Creer les comportements des producteurs
       Producteur[] comportementProd = . . . 
       // . . . 
       // Et les N threads associes
       for (int i = 0; i < nbProducteurs; i++) {
          // . . . . 
       }

       // Nombre de consommateurs parametre du main
       int nbConsommateurs = . . . . 
       // Creer les comportements des consommateurs
       Consommateur[] comportementConso = . . . 
       // . . . . 
       // Et les N threads associes
       for (int i = 0; i < nbConsommateurs; i++) {
          // . . . . 
       }
       System.out.println("Fin lancement application ");
    }
}

