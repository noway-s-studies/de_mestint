/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author mkosa
 */
public class HanoiAllapot extends Allapot {

    public static final int N = 3;

    static {
        operatorok = new HashSet<Operator>();
        for (int mit = 1; mit <= N; ++mit) {
            for (char hova = 'A'; hova <= 'C'; ++hova) {
                operatorok.add(new Mozgat(mit, hova));
            }
        }
    }

    protected char[] h;

    // konstruktor a kezdőállapot beállitására
    public HanoiAllapot() {
        h = new char[N + 1];
        for (int i = 1; i <= N; ++i) {
            h[i] = 'A';
        }
    }

    // másoló konstruktor
    public HanoiAllapot(HanoiAllapot ha) {
        h = new char[N + 1];
        for (int i = 1; i <= N; ++i) {
            h[i] = ha.h[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof HanoiAllapot)) {
            return false;
        }
        HanoiAllapot ha = (HanoiAllapot) o;
        for (int i = 1; i <= N; ++i) {
            if (h[i] != ha.h[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(h, 1, N + 1));
    }

    @Override
    public boolean celAllapot() {
        for (int i = 1; i <= N; ++i) {
            if (h[1] != h[i] || h[i] == 'A') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean elofeltetel(Operator op) throws HibasOperatorException {
        if (op instanceof Mozgat) {
            Mozgat m = (Mozgat) op;
            int mit = m.getMit();
            char hova = m.getHova();
            for (int i = 1; i < mit; i++) {
                if (h[i] == h[mit]) {
                    return false;
                }
            }
            for (int i = 1; i <= mit; i++) {
                if (h[i] == hova) {
                    return false;
                }
            }
            return true;
        }
        throw new HibasOperatorException();
    }

    @Override
    public Allapot alkalmaz(Operator op) throws HibasOperatorException {
        if (op instanceof Mozgat) {
            Mozgat m = (Mozgat)op;
            int mit = m.getMit();
            char hova = m.getHova();
            HanoiAllapot uj = new HanoiAllapot(this);
            uj.h[mit] = hova;
            return uj;
        }
        throw new HibasOperatorException();
    }
}
