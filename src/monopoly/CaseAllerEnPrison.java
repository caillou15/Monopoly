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
public class CaseAllerEnPrison extends Case{

    public CaseAllerEnPrison(String nom) {
	super(nom);
    }
    
    @Override
    public void faireAction(Joueur joueur, Plateau plateau) {
	Util.print(joueur, "doit aller en prison");
	plateau.déplacerJoueur(joueur, -plateau.obtenirTotalCase() / 2, false);
    }
    
}
