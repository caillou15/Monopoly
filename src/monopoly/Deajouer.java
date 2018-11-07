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
public class Deajouer {
    public int obtenir_face() {
	Random rand = new Random();
	int face = 1 + rand.nextInt(6);
	return face;
    }
}
