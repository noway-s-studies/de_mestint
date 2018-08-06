/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoi;

import allapotter.Operator;

/**
 *
 * @author mkosa
 */
public class Mozgat extends Operator {
    private int mit;
    private char hova;

    public Mozgat(int mit, char hova) {
        this.mit = mit;
        this.hova = hova;
    }

    public int getMit() {
        return mit;
    }

    public char getHova() {
        return hova;
    }

    @Override
    public String toString() {
        return "Mozgat(" + mit + ", '" + hova + "')";
    }

    
}
