package Vidampark;

import allapotter.Operator;

public class Honap extends Operator{
    private int gy;
    private int honap;
    
    public Honap(int gy, int honap) {
        this.gy=gy;
        this.honap=honap;
    }
    
    public int getGy() {
        return gy;
    }
    
    public int getHonap() {
        return honap;
    }
    
    @Override
    public String toString() {
        return "Honap(" + gy + "," + honap + ")";
    }
}
