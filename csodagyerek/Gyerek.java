/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csodagyerek;

import allapotter.Operator;

/**
 *
 * @author mkosa
 */
public class Gyerek extends Operator {
    private int cs;
    private int gyerek;

    public Gyerek(int cs, int gyerek) {
        this.cs = cs;
        this.gyerek = gyerek;
    }

    public int getCs() {
        return cs;
    }

    public int getGyerek() {
        return gyerek;
    }

    @Override
    public String toString() {
        return "Gyerek(" + cs + "," + gyerek + ")";
    }


}
