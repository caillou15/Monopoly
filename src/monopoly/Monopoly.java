/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe principale
 *
 * @author admin
 */
public class Monopoly {
    
    Deajouer de = new Deajouer();
    Plateau plateau;
    
    /**
     * Objet qui représente une partie.
     * 
     * @param nombre_joueurs nombre de joueurs dans cette partie
     */
    
    public Monopoly(int nombre_joueurs) {
	plateau = new Plateau(nombre_joueurs);
    }

    /**
     * Fonction d'initialisation
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	/*
        //initialisation
        int finit = 0;
        //boucle de partie
        while (finit == 0) {
	    int des = lancer_des();
            System.out.println(des);
        }
        switch(finit) {
            case 1:System.out.println("Vous avez gagné");
            case 2:System.out.println("Vous avez perdu");
        }
	*/
	System.out.println("\tMonopoly\n");
	Scanner scanner = new Scanner(System.in);
	int nombre_joueurs = 0;
	while (nombre_joueurs < 2 || nombre_joueurs > 8) {	    
	    try {
		System.out.println("Combien de joueurs ?");
		System.out.print("Joueurs (2 - 8)");
		nombre_joueurs = scanner.nextInt();
	    } catch (Exception e) {
		System.err.println("Erreur: Nombre trop grand.");
		continue;
	    }
	    if (nombre_joueurs > 8) {
		System.err.println("Erreur: Nombre de joueur invalide (2 - 8)");
	    }
	}
	scanner.close();
	Monopoly jeu = new Monopoly(nombre_joueurs);
	jeu.démarrerJeu();
    }
    
    
    /**
     * démarre la partie créée
     */
    public void démarrerJeu() {
	System.out.println("Début du jeu!");
	System.out.println("=============");
	while (!estJeuFini() && !plateau.aGagnant()) {	    
	    if (!plateau.obtenirJoueurActuel().estRuine()) {
		int face = plateau.obtenirJoueurActuel().lancerDe(de);
		plateau.déplacerJoueur(plateau.obtenirJoueurActuel(), face);
	    }
	    plateau.tourSuivant();
	}
	System.out.println("==============");
	if (plateau.aGagnant()) {
	    System.out.println(plateau.obtenirGagnant().obtenirNom() + "a gagné car il est le seul à ne pas être ruiné.");
	} else {
	    System.out.println(plateau.obteniJoueurAyantMaxArgent().obtenirNom() + "a gagné car il a le plus d'argent.");
	}
	System.out.println("Game over!");
    }
    
    
    /**
     * retourne true si la partie est finie
     * 
     * @return résultat du test
     */
    public boolean estJeuFini() {
	for (Joueur joueur : plateau.obtenirJoueurs()) {
	    if (joueur.obtenir_deplacement_total() < 20) { return false; }
	}
	return true;
    }
}
