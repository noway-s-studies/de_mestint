package Vidampark;
import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;
import java.util.HashSet;

public class VidamAllapot extends Allapot {
    static {
        operatorok=new HashSet<Operator>();
        for (int gy=1;gy<=5;gy++) {
            operatorok.add(new Honap(gy, 3));
            operatorok.add(new Honap(gy, 4));
            operatorok.add(new Honap(gy, 7));
            operatorok.add(new Honap(gy, 8));
            operatorok.add(new Honap(gy, 11));
            operatorok.add(new Jatek(gy, Jatek.DODZSEM));
            operatorok.add(new Jatek(gy, Jatek.HULLAMVASUT));
            operatorok.add(new Jatek(gy, Jatek.KASTELY));
            operatorok.add(new Jatek(gy, Jatek.KORHINTA));
            operatorok.add(new Jatek(gy, Jatek.SZELLEMVASUT));
            operatorok.add(new Torta(gy, Torta.CSOKOLADE));
            operatorok.add(new Torta(gy, Torta.DIO));
            operatorok.add(new Torta(gy, Torta.KARAMELL));
            operatorok.add(new Torta(gy, Torta.MANDULA));
            operatorok.add(new Torta(gy, Torta.VANILIA));
        }
    }
    
    private int [][] h;
    
    public VidamAllapot() {
        h = new int[6][4];
        for (int i=1;i<=5;i++) {
            for (int j=1;j<=3;j++){
                h[i][j]=0;
            }
        }
    }
    
    public VidamAllapot(VidamAllapot m) {
        h = new int[6][4];
        for (int i=1;i<=5;i++) {
            for (int j=1;j<=3;j++){
                h[i][j]=m.h[i][j];
            }
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (o==null||!(o instanceof VidamAllapot)){
            return false;
        }
        VidamAllapot m = (VidamAllapot)o;
        for (int i=1;i<=5;i++) {
            for (int j=1;j<=3;j++){
                if (h[i][j]!=m.h[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=5;i++) {
            switch(i){
                case 1:
                    sb.append("Csaba: ");
                    break;
                case 2:
                    sb.append("Karola: ");
                    break;
                case 3:
                    sb.append("Paula: ");
                    break;
                case 4:
                    sb.append("Robert: ");
                    break;
                case 5:
                    sb.append("Zsolt: ");
                    break;
            }
        sb.append(h[i][1]).append("   ");
        switch(h[i][2]) {
            case Jatek.DODZSEM:
                sb.append("dodzsem");
                break;
            case Jatek.KASTELY:
                sb.append("kastely");
                break;
            case Jatek.HULLAMVASUT:
                sb.append("hullamvasut");
                break;
            case Jatek.KORHINTA:
                sb.append("korhinta");
                break;
            case Jatek.SZELLEMVASUT:
                sb.append("szellemvasut");
                break;
            default:
                sb.append( "0" );
                break;
        }
        sb.append("   ");
        switch(h[i][3]) {
            case Torta.CSOKOLADE:
                sb.append("csokolade");
                break;
            case Torta.DIO:
                sb.append("dio");
                break;
            case Torta.KARAMELL:
                sb.append("karamell");
                break;
            case Torta.MANDULA:
                sb.append("mandula");
                break;
            case Torta.VANILIA:
                sb.append("vanilia");
                break;
            default:
                sb.append( "0" );
                break;
        }
        sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
    
    @Override
    public boolean celAllapot() {
        if (h[5][3]==0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean elofeltetel(Operator op) throws HibasOperatorException {
        if (op instanceof Honap) {
            int gy=((Honap)op).getGy();
            int honap=((Honap)op).getHonap();
            //31
            if (h[gy][1]!=0) {
                return false;
            }
            //32
            if (gy!=1&&h[gy-1][1]==0) {
                return false;
            }
            //33
            for(int i=1;i<=5;i++) {
                if (i<gy&&h[i][1]==honap) {
                    return false;
                }
            }
            //34
            if (gy==2&&honap==3) {
                return false;
            }
            //35
            if (gy==3&&honap==3) {
                return false;
            }
            //36
            if (((h[3][1]==4||h[3][1]==11)&&gy==5)&&(honap!=4&&honap!=11)) {
                return false;
            }
            //37
            if (((h[3][1]==3||h[3][1]==7||h[3][1]==8)&&gy==5)&&(honap==4||honap==11)) {
                return false;
            }
            //38
            if (gy==2&&(honap!=3&&honap!=4)) {
                return false;
            }
            //39
            for (int i=1;i<=5;i++) {
                if (honap==3&&h[i][1]==4&&i!=2&&gy!=2) {
                    return false;
                }
            }
            //40
            for (int i=1;i<=5;i++) {
                if (honap==4&&h[i][1]==3&&i!=2&&gy!=2) {
                    return false;
                }
            }
            return true;
        } else if (op instanceof Jatek) {
            int gy=((Jatek)op).getGy();
            int jatek=((Jatek)op).getJatek();
            //42
            if (h[gy][2]!=0) {
                return false;
            }
            //43
            if (gy==1&&h[5][1]==0) {
                return false;
            }
            //44
            if (gy!=1&&h[gy-1][2]==0) {
                return false;
            }
            //45
            for(int i=1;i<=5;i++) {
                if (i<gy&&h[i][2]==jatek) {
                    return false;
                }
            }
            //46
            if (gy==1&&jatek==Jatek.KASTELY) {
                return false;
            }
            //47
            if (gy==3&&jatek==Jatek.KASTELY) {
                return false;
            }
            //48
            if (jatek==Jatek.SZELLEMVASUT&&(h[gy][1]!=3&&h[gy][1]!=4)) {
                return false;
            }
            //49
            for(int i=1;i<=5;i++) {
                if ((h[i][1]==4&&h[i][2]!=0&&h[i][2]!=Jatek.SZELLEMVASUT&&h[gy][1]==3)&&jatek!=Jatek.SZELLEMVASUT) {
                    return false;
                }
            }
            //50
            for(int i=1;i<=5;i++) {
                if ((h[i][1]==3&&h[i][2]!=0&&h[i][2]!=Jatek.SZELLEMVASUT&&h[gy][1]==4)&&jatek!=Jatek.SZELLEMVASUT) {
                    return false;
                }
            }
            //51
            if (gy==3&&jatek==Jatek.KORHINTA) {
                return false;
            }
            return true;
        } else if (op instanceof Torta) {
            int gy=((Torta)op).getGy();
            int torta=((Torta)op).getTorta();
            //53
            if (h[gy][3]!=0) {
                return false;
            }
            //54
            if (gy==1&&h[5][2]==0) {
                return false;
            }
            //55
            if (gy!=1&&h[gy-1][3]==0) {
                return false;
            }
            //56
            for(int i=1;i<=5;i++) {
                if (i<gy&&h[i][3]==torta) {
                    return false;
                }
            }
            //57
            if (gy==3&&torta==Torta.VANILIA) {
                return false;
            }
            //58
            if ((h[3][2]!=0&&h[3][2]!=Jatek.SZELLEMVASUT&&torta==Torta.VANILIA)&&h[gy][2]!=Jatek.SZELLEMVASUT) {
                return false;
            }
            //59
            if ((h[3][2]!=0&&h[3][2]!=Jatek.SZELLEMVASUT&&h[gy][2]==Jatek.SZELLEMVASUT)&&torta!=Torta.VANILIA) {
                return false;
            }
            //60
            if (gy==1&&torta==Torta.CSOKOLADE) {
                return false;
            }
            //61
            if (gy==3&&torta==Torta.CSOKOLADE) {
                return false;
            }
            //62
            if (torta==Torta.CSOKOLADE&&h[gy][1]==11) {
                return false;
            }
            //63
            if (torta==Torta.MANDULA&&(h[gy][1]>=h[3][1])) {
                return false;
            }
            //64
            if (gy==2&&torta==Torta.MANDULA) {
                return false;
            }
            //65
            if (torta==Torta.MANDULA&&h[gy][2]==Jatek.HULLAMVASUT) {
                return false;
            }
            //66
            if (gy==1&&torta==Torta.DIO) {
                return false;
            }
            //67
            if (gy==3&&torta==Torta.DIO) {
                return false;
            }
            //68
            if (torta==Torta.DIO&&h[gy][2]==Jatek.KORHINTA) {
                return false;
            }
            //69
            if (torta==Torta.CSOKOLADE&&(h[gy][1]!=8&&h[gy][1]!=11)) {
                return false;
            }
            //70
            for(int i=1;i<=5;i++) {
                if ((h[gy][1]==8&&h[i][1]==11&&h[i][3]!=0&&h[i][3]!=Torta.CSOKOLADE)&&torta!=Torta.CSOKOLADE) {
                    return false;
                }
            }
            //71
            for(int i=1;i<=5;i++) {
                if ((h[gy][1]==11&&h[i][1]==8&&h[i][3]!=0&&h[i][3]!=Torta.CSOKOLADE)&&torta!=Torta.CSOKOLADE) {
                    return false;
                }
            }
            //72
            if (h[gy][2]==Jatek.KORHINTA&&torta==Torta.MANDULA) {
                return false;
            }
            return true;
        }
        throw new HibasOperatorException();
    }

    @Override
    public Allapot alkalmaz(Operator op) throws HibasOperatorException {
        if (op instanceof Honap) {
            int gy=((Honap)op).getGy();
            int honap=((Honap)op).getHonap();
            VidamAllapot uj = new VidamAllapot(this);
            uj.h[gy][1]=honap;
            return uj;
        } else if (op instanceof Jatek) {
            int gy=((Jatek)op).getGy();
            int jatek=((Jatek)op).getJatek();
            VidamAllapot uj = new VidamAllapot(this);
            uj.h[gy][2]=jatek;
            return uj;
        } else if (op instanceof Torta) {
            int gy=((Torta)op).getGy();
            int torta=((Torta)op).getTorta();
            VidamAllapot uj = new VidamAllapot(this);
            uj.h[gy][3]=torta;
            return uj;
        }
        throw new HibasOperatorException();
    }    
}