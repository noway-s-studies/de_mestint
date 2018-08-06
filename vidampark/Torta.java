package Vidampark;

import allapotter.Operator;
public class Torta extends Operator{
    public static final int CSOKOLADE=1, DIO=2, KARAMELL=3, MANDULA=4, VANILIA=5;
    private int gy, torta;
    
    public Torta(int gy, int torta) {
        this.gy=gy;
        this.torta=torta;
    }
    
    public int getGy() {
        return gy;
    }
    
    public int getTorta() {
        return torta;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Torta(").append(gy).append(",");
        switch(torta) {
            case CSOKOLADE:
                sb.append("csokolade");
                break;
            case DIO:
                sb.append("dio");
                break;
            case KARAMELL:
                sb.append("karamell");
                break;
            case MANDULA:
                sb.append("mandula");
                break;
            case VANILIA:
                sb.append("vanilia");
                break;
        }
        sb.append(")");
        return sb.toString();
    }
}