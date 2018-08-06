package szorpkostolo;

import allapotter.Operator;

public class SzorpPont extends Operator {

    protected int szorp;
    protected int pont;

    public int getPont() {
        return pont;
    }

    public int getSzorp() {
        return szorp;
    }

    public SzorpPont(int szorp, int pont) {
        this.szorp = szorp;
        this.pont = pont;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append( "Pont[" ).append( szorp ).append( "," ).append( pont ).append( "]" );
        return sb.toString();
    }

}
