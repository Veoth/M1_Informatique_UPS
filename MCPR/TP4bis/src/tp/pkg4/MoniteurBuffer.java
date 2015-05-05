/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg4;

public class MoniteurBuffer {
  // Type de messages qu'on peut y deposer/retirer
  int monType;
  // Boite contenant les messages
  Message buffer[]; 
  // Nombre de cases dans cette boite
  private int maCapacite;
  // Variable utiles pour la synchronisation
  // A completer
  // . . . 
  // Variables d'etat
  // A completer
  // . . . 
	   
  // Constructeur de la classe
  public MoniteurBuffer (int nbCasesBuffer, int unType) {
    monType = unType;
    maCapacite = nbCasesBuffer;
    // A completer
    // . . . 
  }
  
  // Deposer un message d'un certain type 
  // et reveiller un consommateur en attente eventuelle de ce type de message
  public void deposer (Message unMsg) throws InterruptedException {
    // Assurer l'exclusion mutuelle entre les operations du "moniteur"
    // . . .
    // Se bloquer si on ne peut pas deposer
    // . . . 
    // On a acces au buffer et on peut deposer
    // . . . 
    // On a cree une case pleine => reveiller un consommateur attendant ce type
    // . . . 
  }
	   
  // Retirer le 1er message disponible du buffer
  public Message retirer(Message unMessage) {
    // Assurer l'exclusion mutuelle entre les operations du "moniteur"
    // . . .
    // Se bloquer si on ne peut rien retirer
    // . . .
    // On a acces au buffer et on peut retirer
    // . . . 
    // On a cree une case vide => reveiller un producteur du bon type
    // . . . 
  }	   
}