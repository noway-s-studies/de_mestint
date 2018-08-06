/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csodagyerek;

import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;
import java.util.HashSet;

/**
 *
 * @author mkosa
 */
public class MargitAllapot extends Allapot {
    static {
        operatorok = new HashSet<Operator>();
        for (int cs = 1; cs <= 5; cs++) {
            operatorok.add(new Lakohely(cs, Lakohely.ANGYALFOLD));
            operatorok.add(new Lakohely(cs, Lakohely.BELVAROS));
            operatorok.add(new Lakohely(cs, Lakohely.CSILLAGHEGY));
            operatorok.add(new Lakohely(cs, Lakohely.OBUDA));
            operatorok.add(new Lakohely(cs, Lakohely.UJPEST));
            operatorok.add(new Tevekenyseg(cs, Tevekenyseg.FOCI));
            operatorok.add(new Tevekenyseg(cs, Tevekenyseg.GORKORCSOLYA));
            operatorok.add(new Tevekenyseg(cs, Tevekenyseg.KEREKPAR));
            operatorok.add(new Tevekenyseg(cs, Tevekenyseg.KOCOGAS));
            operatorok.add(new Tevekenyseg(cs, Tevekenyseg.TOLLASLABDA));
            operatorok.add(new Gyerek(cs, 1));
            operatorok.add(new Gyerek(cs, 2));
            operatorok.add(new Gyerek(cs, 3));
            operatorok.add(new Gyerek(cs, 4));
            operatorok.add(new Gyerek(cs, 5));
        }
    }

    private int[][] h;

    public MargitAllapot() {
        h = new int[6][4];
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                h[i][j] = 0;
            }
        }
    }

    public MargitAllapot(MargitAllapot m) {
        h = new int[6][4];
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                h[i][j] = m.h[i][j];
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof MargitAllapot)) {
            return false;
        }
        MargitAllapot m = (MargitAllapot)o;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                if (h[i][j] != m.h[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
       StringBuffer sb = new StringBuffer();
        for ( int i = 1; i <= 5; ++i ) {
            switch ( i ) {
                case 1:
                    sb.append( "Bognarek:" );
                    break;
                case 2:
                    sb.append( "Kardosek:" );
                    break;
                case 3:
                    sb.append( "Szucsek: " );
                    break;
                case 4:
                    sb.append( "Vadaszek:" );
                    break;
                case 5:
                    sb.append( "Vargaek: " );
                    break;
            }
            sb.append( " " ).append( h[i][1] );
            sb.append( " " );
            switch ( h[i][2] ) {
                case Lakohely.ANGYALFOLD:
                    sb.append( "Angyalfold " );
                    break;
                case Lakohely.BELVAROS:
                    sb.append( "Belvaros   " );
                    break;
                case Lakohely.CSILLAGHEGY:
                    sb.append( "Csillaghegy" );
                    break;
                case Lakohely.OBUDA:
                    sb.append( "Obuda      " );
                    break;
                case Lakohely.UJPEST:
                    sb.append( "Ujpest     " );
                    break;
                default:
                    sb.append( "0          " );
                    break;
            }
            sb.append( " " );
            switch ( h[i][3] ) {
                case Tevekenyseg.FOCI:
                    sb.append( "foci" );
                    break;
                case Tevekenyseg.GORKORCSOLYA:
                    sb.append( "gorkorcsolya" );
                    break;
                case Tevekenyseg.KEREKPAR:
                    sb.append( "kerekpar" );
                    break;
                case Tevekenyseg.KOCOGAS:
                    sb.append( "kocogas" );
                    break;
                case Tevekenyseg.TOLLASLABDA:
                    sb.append( "tollaslabda" );
                    break;
                default:
                    sb.append( "0" );
                    break;
            }
            sb.append( System.getProperty( "line.separator" ) );
        }
        return sb.toString();
    }

    @Override
    public boolean celAllapot() {
        return h[5][3] != 0;
    }

    @Override
    public boolean elofeltetel(Operator op) throws HibasOperatorException {
        if (op instanceof Gyerek) {
            int cs = ((Gyerek)op).getCs();
            int gyerek = ((Gyerek)op).getGyerek();
            // 25
            if (h[cs][1] != 0) {
                return false;
            }
            // 26
            if (cs != 1 && h[cs-1][1] == 0) {
                return false;
            }
            // 27
            for (int i = 1; i <= 5; i++) {
                if (i < cs && h[i][1] == gyerek) {
                    return false;
                }
            }
            // 28
            if (cs == 3 && gyerek != 2) {
                return false;
            }
            // 29
            if (gyerek == 2 && cs != 3) {
                return false;
            }
            // 30
            if (cs == 4 && gyerek == 5) {
                return false;
            }

            return true;
        } else if (op instanceof Lakohely) {
            int cs = ((Lakohely)op).getCs();
            int lakohely = ((Lakohely)op).getLakohely();
            // 32
            if (h[cs][2] != 0) {
                return false;
            }
            // 33
            if (cs == 1 && h[5][1] == 0) {
                return false;
            }
            // 34
            if (cs != 1 && h[cs-1][2] == 0) {
                return false;
            }
            // 35
            for (int i = 1; i <= 5; i++) {
                if (i < cs && h[i][2] == lakohely) {
                    return false;
                }
            }
            // 36
            if (cs == 2 &&
                    (lakohely != Lakohely.CSILLAGHEGY &&
                     lakohely != Lakohely.OBUDA)) {
                return false;
            }
            // 37
            if (lakohely == Lakohely.CSILLAGHEGY && h[cs][1] == 5) {
                return false;
            }
            // 38
            if (lakohely == Lakohely.BELVAROS && h[cs][1] != 1) {
                return false;
            }
            // 39
            if (cs == 3 && lakohely == Lakohely.BELVAROS) {
                return false;
            }
            // 40
            if (cs == 4 && lakohely != Lakohely.UJPEST) {
                return false;
            }
            // 41
            if (lakohely == Lakohely.UJPEST && cs != 4) {
                return false;
            }

            return true;
        } else if (op instanceof Tevekenyseg) {
            int cs = ((Tevekenyseg)op).getCs();
            int tevekenyseg = ((Tevekenyseg)op).getTevekenyseg();
            // 43
            if (h[cs][3] != 0) {
                return false;
            }
            // 44
            if (cs == 1 && h[5][2] == 0) {
                return false;
            }
            // 45
            if (cs != 1 && h[cs-1][3] == 0) {
                return false;
            }
            // 46
            for (int i = 1; i <= 5; i++) {
                if (i < cs && h[i][3] == tevekenyseg) {
                    return false;
                }
            }
            // 47
            if (h[cs][2] == Lakohely.ANGYALFOLD && tevekenyseg != Tevekenyseg.GORKORCSOLYA) {
                return false;
            }
            // 48
            if (tevekenyseg == Tevekenyseg.GORKORCSOLYA && h[cs][2] != Lakohely.ANGYALFOLD) {
                return false;
            }
            // 49
            if (tevekenyseg == Tevekenyseg.KEREKPAR && cs != 2) {
                return false;
            }
            // 50
            if (cs == 2 && tevekenyseg != Tevekenyseg.KEREKPAR) {
                return false;
            }
            // 51
            if (tevekenyseg == Tevekenyseg.FOCI && h[cs][1] != 5) {
                return false;
            }
            // 52
            if (h[cs][1] == 5 && tevekenyseg != Tevekenyseg.FOCI) {
                return false;
            }
            // 53
            if (h[cs][2] == Lakohely.CSILLAGHEGY && tevekenyseg == Tevekenyseg.TOLLASLABDA) {
                return false;
            }
            // 54
            if (tevekenyseg == Tevekenyseg.TOLLASLABDA && h[cs][1] == 1) {
                return false;
            }
            // 55
            if (tevekenyseg == Tevekenyseg.TOLLASLABDA) {
                for (int i = 1; i <= 5; i++) {
                    if (h[i][2] == Lakohely.CSILLAGHEGY && h[i][1] >= h[cs][1]) {
                        return false;
                    }
                }
            }
            // 56
            if (cs == 1 && tevekenyseg == Tevekenyseg.KOCOGAS) {
                return false;
            }

            return true;
        }
        throw new HibasOperatorException();
    }

    @Override
    public Allapot alkalmaz(Operator op) throws HibasOperatorException {
        if (op instanceof Gyerek) {
            int cs = ((Gyerek)op).getCs();
            int gyerek = ((Gyerek)op).getGyerek();
            MargitAllapot uj = new MargitAllapot(this);
            uj.h[cs][1] = gyerek;
            return uj;
        } else if (op instanceof Lakohely) {
            int cs = ((Lakohely)op).getCs();
            int lakohely = ((Lakohely)op).getLakohely();
            MargitAllapot uj = new MargitAllapot(this);
            uj.h[cs][2] = lakohely;
            return uj;
        } else if (op instanceof Tevekenyseg) {
            int cs = ((Tevekenyseg)op).getCs();
            int tevekenyseg = ((Tevekenyseg)op).getTevekenyseg();
            MargitAllapot uj = new MargitAllapot(this);
            uj.h[cs][3] = tevekenyseg;
            return uj;
        }
        throw new HibasOperatorException();
    }


}
