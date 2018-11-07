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
public class Argent {
    int argent;
    
    public Argent() {
	this(0);
    }
    
    public Argent(int argent) {
	this.argent = argent;
    }
    
    public int obtenirArgent() {
	return argent;
    }
    
    public void ajouterArgent(int qte) {
	argent += qte;
    }
    
    public void retirerArgent(int qte) {
	argent -= qte;
    }
    
    public boolean estRuine() {
	return argent < 0;
    }
}
