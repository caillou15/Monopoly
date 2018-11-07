/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;

/**
 * Correspond au plateau de jeu
 *
 * @author admin
 */
public class Plateau {
    
    int tour_actuel = 0;
    int nombre_joueurs = 0;
    Joueur[] joueurs;
    Case[] cases = new Case[40];
    String[] noms = { "rue de vaugirard" };
    
    /**
     * plateau de jeu d'une partie
     * 
     * @param nombre_joueurs nombre de joueurs de la partie
     */
    public Plateau(int nombre_joueurs) {
	joueurs = new Joueur[nombre_joueurs];
	this.nombre_joueurs = nombre_joueurs;
	for (int i = 0;i < joueurs.length;i++) {
	    joueurs[i] = new Joueur(i, "Joueur " + (i + 1));
	}
	Random random = new Random();
	for (int i = 0;i < cases.length;i++) {
	    switch(i) {
		/*
		@todo nom des rues
		*/
		case 0: cases[i] = new CaseDepart("Départ");
		case 9: cases[9] = new Case_prison("Prison");
		case 19: cases[19] = new CaseParc("Parc gratuit");
		case 29: cases[29] = new Case_prison("Fortune");
		default: cases[i] = new CaseRue("rue", 1000);
	    }
	}
    }
    
    public Case déplacerJoueur(Joueur joueur, int face) {
	return déplacerJoueur(joueur, face, true);
    }
    
    /**
     * déplace le joueur du nombre de cases indiqué
     * 
     * @param joueur joueur ciblé
     * @param face nombre de cases du déplacement
     * @param compte
     * @return 
     */
    public Case déplacerJoueur(Joueur joueur, int face, boolean compte) {
	if (joueur.estRuine()) { return cases[joueur.obtenir_position_actuelle()]; }
	int nouvellePosition = normalisePosition(joueur.obtenir_position_actuelle() + face);
	joueur.setPosition(nouvellePosition);
	Util.print(joueur, joueur.obtenirNom() + " va vers " + cases[joueur.obtenir_position_actuelle()].obtenirNom());
	cases[nouvellePosition].faireAction(joueur, this);
	if (joueur.obtenirArgent().estRuine()) {
	    Util.print(joueur, joueur.obtenirNom() + " est ruiné!");
	    joueur.setRuine(true);
	} else {
	    if (compte) {
		joueur.tourSuivant();
	    }
	}
	return cases[nouvellePosition];
    }
    
    public boolean aGagnant() {
	int enjeu = 0;
	for (Joueur joueur:joueurs) {
	    if (!joueur.estRuine()) {
		enjeu++;
	    }
	}
	return enjeu <= 1;
    }
    
    public Joueur obtenirGagnant() {
	if (!aGagnant()) {return null;}
	for (Joueur joueur:joueurs) {
	    if (!joueur.estRuine()) { return joueur; }
	}
	return null;
    }
    
    public Joueur obteniJoueurAyantMaxArgent() {
	Joueur maxJoueur = null;
	for (Joueur joueur:joueurs) {
	    if (maxJoueur == null || maxJoueur.obtenirArgent().obtenirArgent() < joueur.obtenirArgent().obtenirArgent()) {
		maxJoueur = joueur;
	    }
	}
	return maxJoueur;
    }
    
    public int normalisePosition(int position) {
	return position % cases.length;
    }
    
    public Joueur obtenirJoueurActuel() {
	return joueurs[tour_actuel];
    }
    
    public Joueur[] obtenirJoueurs() {
	return joueurs;
    }
    
    public void tourSuivant() {
	if (++tour_actuel >= joueurs.length) {
	    tour_actuel = 0;
	}
    }
    
    public Joueur obtenirJoueur(int id) {
	return joueurs[id];
    }
    
    public int obtenirTotalCase() {
	return  cases.length;
    }
}