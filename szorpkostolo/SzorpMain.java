package szorpkostolo;

import allapotter.Allapot;
import kereso.Csucs;
import kereso.Kereso;
import kereso.keresografos.szisztematikus.SzelessegiKereso;

public class SzorpMain {

    public static void main( String[] args ) {
        Allapot kezdo = new SzorpAllapot();
//        Kereso k = new BacktrackKereso(kezdo, BacktrackKereso.OSSZES_MEGOLDAS);
        Kereso k = new SzelessegiKereso( kezdo, SzelessegiKereso.MEGOLDAS_ALLAPOT | SzelessegiKereso.OSSZES_MEGOLDAS );
//        Kereso k = new MelysegiKereso(kezdo, MelysegiKereso.MEGOLDAS_ALLAPOT | MelysegiKereso.OSSZES_MEGOLDAS);
        k.keres();
        for ( Csucs cs : k.getTerminalisok() ) {
            System.out.println( "Egy megoldas" );
            k.kiirMegoldas( cs );
        }

        System.out.println( "Megoldasok szama: " + k.getTerminalisok().size() );
    }

}
