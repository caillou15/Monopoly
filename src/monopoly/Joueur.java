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
public class Joueur {
    int déplacement_total = 0;
    int position = 0;
    int id;
    String nom;
    boolean ruine = false;
    Argent argent = new Argent(5000);
    /*
     * @todo couleur du joueur
     */
    public Joueur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public int obtenir_deplacement_total() {
	return déplacement_total;
    }
    
    public int lancerDe(Deajouer de) {
	//int face = de.obtenir_face();
	int face = de.obtenir_face();
	Util.print(this, "lance le dé... Le résultat est " + face);
	return face;
    }
    
    public int obtenir_position_actuelle() {
	return position;
    }
    
    public void setPosition(int position) {
	this.position = position;
    }
    
    public void tourSuivant() {
	déplacement_total++;
    }
    
    public String obtenirNom() {
	return nom;
    }
    
    public Argent obtenirArgent() {
	return argent;
    }
    public int obtenirID() {
	return id;
    }
    
    public void setRuine(boolean ruine) {
	this.ruine = ruine;
    }
    
    public boolean estRuine() {
	return ruine;
    }
}
