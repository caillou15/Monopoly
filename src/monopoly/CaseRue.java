/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;

/**
 *
 * @author admin
 */
/*
@todo couleur de la rue
*/
public class CaseRue extends Case{
    int prix;
    int proprietaire = -1;

    public CaseRue(String nom, int prix) {
	super(nom);
	this.prix = prix;
    }

    public void setProprietaire(int proprietaire) {
	this.proprietaire = proprietaire;
    }

    public int ObtenirPrix() {
	return prix;
    }
    
    @Override
    public void faireAction(Joueur joueur, Plateau plateau) {
	Util.print(joueur, joueur.obtenirNom() + " est à la case " + nom);
	if (proprietaire < 0) {
	    Util.print(joueur, joueur.obtenirNom() + ", voulez-vous acheter " + obtenirNom() + "?");
	    Random rand = new Random();
	    if (rand.nextBoolean()) {
		Util.print(joueur, joueur.obtenirNom() + " achète " + obtenirNom());
		proprietaire = joueur.obtenirID();
		joueur.obtenirArgent().retirerArgent(prix);
	    } else {
		Util.print(joueur, joueur.obtenirNom() + " ne veux pas acheter" + obtenirNom());
	    }
	} else {
	    if (proprietaire != joueur.obtenirID()) {
		int perte = prix * 70/100;
		Util.print(joueur, joueur.obtenirNom() + " perd " + perte + " euros de " + plateau.obtenirJoueur(proprietaire).obtenirNom());
		joueur.obtenirArgent().retirerArgent(perte);
		plateau.obtenirJoueur(proprietaire).obtenirArgent().ajouterArgent(perte);
	    }
	}
    }
    
}
