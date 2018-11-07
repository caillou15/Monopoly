/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;
import monopoly.Case;

/**
 *
 * @author admin
 */
public class CaseParc extends Case{
    
    public CaseParc(String nom) {
	super(nom);
    }

    @Override
    public void faireAction(Joueur joueur, Plateau plateau) {
	Random rand = new Random();
	Case uneCase = plateau.déplacerJoueur(joueur, rand.nextInt(plateau.obtenirTotalCase()), false);
	Util.print(joueur, joueur.obtenirNom() + "va dans la case 'parc'");
    }
    
}
