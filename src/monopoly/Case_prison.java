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
public class Case_prison extends Case{
    
    public Case_prison(String nom) {
	super(nom);
    }

    @Override
    public void faireAction(Joueur joueur, Plateau plateau) {
	Util.print(joueur, joueur.obtenirNom() + "a été en prison et perd 500 €");
	joueur.obtenirArgent().retirerArgent(500);
    }
    
}
