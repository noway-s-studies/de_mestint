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
public class Tevekenyseg extends Operator {
    public static final int GORKORCSOLYA = 1,
            FOCI = 2,
            KEREKPAR = 3,
            KOCOGAS = 4,
            TOLLASLABDA = 5;

    private int cs;
    private int tevekenyseg;

    public Tevekenyseg(int cs, int tevekenyseg) {
        this.cs = cs;
        this.tevekenyseg = tevekenyseg;
    }

    public int getCs() {
        return cs;
    }

    public int getTevekenyseg() {
        return tevekenyseg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tevekenyseg(").append(cs).append(",");
        switch (tevekenyseg) {
            case FOCI:
                sb.append("foci");
                break;
            case GORKORCSOLYA:
                sb.append("gorkorcsolya");
                break;
            case KEREKPAR:
                sb.append("kerekpar");
                break;
            case KOCOGAS:
                sb.append("kocogas");
                break;
            case TOLLASLABDA:
                sb.append("tollaslabda");
                break;
        }
        sb.append(")");
        return sb.toString();
    }

}
