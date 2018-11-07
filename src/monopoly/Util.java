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
public class Util {
    //@Override
    public static void print(Joueur joueur, String msg) {
	System.out.println("[Tour " + (joueur.obtenir_deplacement_total()+ 1) + "] [" + joueur.obtenir_position_actuelle()+ "] [" + joueur.obtenirArgent().obtenirArgent() + "€] " + msg);
    }
}
