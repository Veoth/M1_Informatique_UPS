/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4;
// Producteurs-Consommateurs
// Classe definissant les messages manipules
//
public class Message {
  // Une valeur entiere	
  private int valeur;
  // Un numero identifiant l'expediteur
  private long idExpediteur;
  // Un type possible pour le message
  private int type;
  
  // Constructeur
  public Message (int laValeur, long lExpediteur, int leType)  {
  valeur = laValeur;
  idExpediteur = lExpediteur;
  type = leType;
  }

  // Obtention de la valeur
  public int getValeur() {
    return valeur;
  }

  // Restitution de la valeur
  public int getType () {
    return type;
  }

  // Affichage des attributs du message
  public void afficherMessage () {
    System.out.println("("+valeur+", "+type+")"); 
  }
}


