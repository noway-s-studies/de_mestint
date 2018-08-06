/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoi;

import allapotter.Allapot;
import kereso.Csucs;
import kereso.Kereso;
import kereso.backtrack.BacktrackKereso;

/**
 *
 * @author mkosa
 */
public class HanoiTeszt {
    public static void main(String[] args) {
        Allapot kezdo = new HanoiAllapot();
        System.out.println(kezdo);
        Kereso k = new BacktrackKereso(kezdo, BacktrackKereso.KOR_FIGYELES);
        k.keres();

        System.out.println("A megoldások:");
        for (Csucs term : k.getTerminalisok()) {
            System.out.println("-----");
            System.out.println("Találtam egy megoldást!");
            k.kiirMegoldas(term);
        }
    }
}
