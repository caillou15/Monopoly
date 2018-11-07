/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import monopoly.Util;
/**
 *
 * @author admin
 */
public class CaseDepart extends Case{
    public CaseDepart(String nom) {
	super(nom);
    }
    
    @Override
    public void faireAction(Joueur joueur, Plateau plateau) {
	Util.print(joueur, joueur.obtenirNom()+ " est à la case Départ... On lui donnne 1000 €");
	joueur.obtenirArgent().ajouterArgent(1000);
    }
}
