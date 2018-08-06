package szorpkostolo;

import allapotter.Operator;

public class SzorpVaros extends Operator {

    public static final int SARKAD = 1, SARVAR = 2, SOLYMAR = 3, SOPRON = 4, SZOB = 5;

    protected int szorp;
    protected int varos;

    public SzorpVaros(int szorp, int varos) {
        this.szorp = szorp;
        this.varos = varos;
    }

    public int getVaros() {
        return varos;
    }

    public int getSzorp() {
        return szorp;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append( "Varos[" ).append( szorp ).append( "," );
        switch ( varos ) {
            case SARKAD:
                sb.append( "Sarkad" );
                break;
            case SARVAR:
                sb.append( "Sarvar" );
                break;
            case SOLYMAR:
                sb.append( "Solymar" );
                break;
            case SOPRON:
                sb.append( "Sopron" );
                break;
            case SZOB:
                sb.append( "Szob" );
                break;
        }
        sb.append( "]" );
        return sb.toString();
    }

}
