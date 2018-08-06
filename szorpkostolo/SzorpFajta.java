package szorpkostolo;

import allapotter.Operator;

public class SzorpFajta extends Operator {

    public static final int AFONYA = 1, BIRSKORTE = 2, EPER = 3, MALNA = 4, SZEDER = 5;

    protected int szorp;
    protected int fajta;

    public SzorpFajta(int szorp, int fajta) {
        this.szorp = szorp;
        this.fajta = fajta;
    }

    public int getFajta() {
        return fajta;
    }

    public int getSzorp() {
        return szorp;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append( "Fajta[" ).append( szorp ).append( "," );
        switch ( fajta ) {
            case AFONYA:
                sb.append( "afonya" );
                break;
            case BIRSKORTE:
                sb.append( "birskorte" );
                break;
            case EPER:
                sb.append( "eper" );
                break;
            case MALNA:
                sb.append( "malna" );
                break;
            case SZEDER:
                sb.append( "szeder" );
                break;
        }
        sb.append( "]" );
        return sb.toString();
    }

}
