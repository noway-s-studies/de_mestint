package Vidampark;

import allapotter.Operator;

public class Jatek extends Operator{    
    public static final int DODZSEM=1, KASTELY=2, HULLAMVASUT=3, KORHINTA=4, SZELLEMVASUT=5;
    private int gy, jatek;
    
    public Jatek(int gy, int jatek) {
        this.gy=gy;
        this.jatek=jatek;
    }
    
    public int getGy() {
        return gy;
    }
    
    public int getJatek() {
        return jatek;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jatek(").append(gy).append(",");
        switch(jatek) {
            case DODZSEM:
                sb.append("dodzsem");
                break;
            case KASTELY:
                sb.append("kastely");
                break;
            case HULLAMVASUT:
                sb.append("hullamvasut");
                break;
            case KORHINTA:
                sb.append("korhinta");
                break;
            case SZELLEMVASUT:
                sb.append("szellemvasut");
                break;
        }
        sb.append(")");
        return sb.toString();
    }
}