package Vidampark;
import allapotter.Allapot;
import kereso.Csucs;
import kereso.Kereso;
import kereso.backtrack.BacktrackKereso;
import kereso.keresografos.szisztematikus.MelysegiKereso;
import kereso.keresografos.szisztematikus.SzelessegiKereso;

public class VidamTeszt {
    public static void main(String[] args){
        Allapot kezdo=new VidamAllapot();
        Kereso k = new BacktrackKereso(kezdo, BacktrackKereso.OSSZES_MEGOLDAS);
//        Kereso k = new SzelessegiKereso(kezdo, SzelessegiKereso.MEGOLDAS_ALLAPOT|SzelessegiKereso.OSSZES_MEGOLDAS);
//        Kereso k = new MelysegiKereso(kezdo, MelysegiKereso.MEGOLDAS_ALLAPOT | MelysegiKereso.OSSZES_MEGOLDAS);
        k.keres();
        for(Csucs cs:k.getTerminalisok()){
            System.out.println("Egy megoldás: ");
            k.kiirMegoldas(cs);
        }
        System.out.println("Megoldások száma: " + k.getTerminalisok().size());
    }
}
