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
public class Lakohely extends Operator {

    public static final int ANGYALFOLD = 1,
            BELVAROS = 2,
            CSILLAGHEGY = 3,
            OBUDA = 4,
            UJPEST = 5;

    private int cs;
    private int lakohely;

    public Lakohely(int cs, int lakohely) {
        this.cs = cs;
        this.lakohely = lakohely;
    }

    public int getCs() {
        return cs;
    }

    public int getLakohely() {
        return lakohely;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lakohely(").append(cs).append(",");
        switch (lakohely) {
            case ANGYALFOLD:
                sb.append("Angyalfold");
                break;
            case BELVAROS:
                sb.append("Belvaros");
                break;
            case CSILLAGHEGY:
                sb.append("Csillaghegy");
                break;
            case OBUDA:
                sb.append("Obuda");
                break;
            case UJPEST:
                sb.append("Ujpest");
                break;
        }
        sb.append(")");
        return sb.toString();
    }


}
