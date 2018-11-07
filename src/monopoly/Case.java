/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author admin
 */
public abstract class Case {
    String nom;
    
    Case(String nom) {
	this.nom = nom;
    }
    
    public String obtenirNom() {
	return nom;
    }
    public abstract void faireAction(Joueur joueur, Plateau plateau);
}
