package szorpkostolo;

import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;
import java.util.HashSet;

public class SzorpAllapot extends Allapot {

    static {
        operatorok = new HashSet<Operator>();
        for ( int i = 1; i <= 5; ++i ) {
            operatorok.add( new SzorpFajta( i, SzorpFajta.AFONYA ) );
            operatorok.add( new SzorpFajta( i, SzorpFajta.BIRSKORTE ) );
            operatorok.add( new SzorpFajta( i, SzorpFajta.EPER ) );
            operatorok.add( new SzorpFajta( i, SzorpFajta.MALNA ) );
            operatorok.add( new SzorpFajta( i, SzorpFajta.SZEDER ) );
            operatorok.add( new SzorpVaros( i, SzorpVaros.SARKAD ) );
            operatorok.add( new SzorpVaros( i, SzorpVaros.SARVAR ) );
            operatorok.add( new SzorpVaros( i, SzorpVaros.SOLYMAR ) );
            operatorok.add( new SzorpVaros( i, SzorpVaros.SOPRON ) );
            operatorok.add( new SzorpVaros( i, SzorpVaros.SZOB ) );
            operatorok.add( new SzorpPont( i, 40 ) );
            operatorok.add( new SzorpPont( i, 50 ) );
            operatorok.add( new SzorpPont( i, 60 ) );
            operatorok.add( new SzorpPont( i, 70 ) );
            operatorok.add( new SzorpPont( i, 100 ) );
        }
    }
    protected int[][] h;

    public SzorpAllapot() {
        h = new int[ 6 ][ 4 ];
        for ( int i = 1; i <= 5; ++i ) {
            for ( int j = 1; j <= 3; ++j ) {
                h[i][j] = 0;
            }
        }
    }

    public SzorpAllapot( SzorpAllapot sz ) {
        h = new int[ 6 ][ 4 ];
        for ( int i = 1; i <= 5; ++i ) {
            for ( int j = 1; j <= 3; ++j ) {
                h[i][j] = sz.h[i][j];
            }
        }
    }

    @Override
    public boolean celAllapot() {
        return h[5][3] != 0;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null || !( obj instanceof SzorpAllapot ) ) {
            return false;
        }
        SzorpAllapot sz = ( SzorpAllapot ) obj;
        for ( int i = 1; i <= 5; ++i ) {
            for ( int j = 1; j <= 3; ++j ) {
                if ( h[i][j] != sz.h[i][j] ) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for ( int i = 1; i <= 5; ++i ) {
            switch ( i ) {
                case 1:
                    sb.append( "Bizony Finom:   " );
                    break;
                case 2:
                    sb.append( "Mezes Edes:     " );
                    break;
                case 3:
                    sb.append( "Pompas Forras:  " );
                    break;
                case 4:
                    sb.append( "Remek Permet:   " );
                    break;
                case 5:
                    sb.append( "Zamatos Darabos:" );
                    break;
            }
            sb.append( " " );
            switch ( h[i][1] ) {
                case SzorpFajta.AFONYA:
                    sb.append( "afonya   " );
                    break;
                case SzorpFajta.BIRSKORTE:
                    sb.append( "birskorte" );
                    break;
                case SzorpFajta.EPER:
                    sb.append( "eper     " );
                    break;
                case SzorpFajta.MALNA:
                    sb.append( "malna    " );
                    break;
                case SzorpFajta.SZEDER:
                    sb.append( "szeder   " );
                    break;
                default:
                    sb.append( "0          " );
                    break;
            }
            sb.append( " " );
            switch ( h[i][2] ) {
                case SzorpVaros.SARKAD:
                    sb.append( "Sarkad " );
                    break;
                case SzorpVaros.SARVAR:
                    sb.append( "Sarvar " );
                    break;
                case SzorpVaros.SOLYMAR:
                    sb.append( "Solymar" );
                    break;
                case SzorpVaros.SOPRON:
                    sb.append( "Sopron " );
                    break;
                case SzorpVaros.SZOB:
                    sb.append( "Szob   " );
                    break;
                default:
                    sb.append( "0" );
                    break;
            }
            sb.append( " " ).append( h[i][3] );
            sb.append( System.getProperty( "line.separator" ) );
        }
        return sb.toString();
    }

    @Override
    public boolean elofeltetel( Operator op ) throws HibasOperatorException {
        if ( op instanceof SzorpFajta ) {
            SzorpFajta szorpFajta = ( SzorpFajta ) op;
            int sz = szorpFajta.getSzorp();
            int fajta = szorpFajta.getFajta();
            if ( h[sz][1] != 0 ) {
                return false;
            }
            if ( sz != 1 && h[sz - 1][1] == 0 ) {
                return false;
            }
            for ( int i = 1; i < sz; ++i ) {
                if ( h[i][1] == fajta ) {
                    return false;
                }
            }
            if ( sz == 5 && fajta == SzorpFajta.EPER ) {
                return false;
            }
            if ( sz == 1 && fajta != SzorpFajta.AFONYA ) {
                return false;
            }
            if ( sz != 1 && fajta == SzorpFajta.AFONYA ) {
                return false;
            }
            return true;
        } else if ( op instanceof SzorpVaros ) {
            SzorpVaros szorpVaros = ( SzorpVaros ) op;
            int sz = szorpVaros.getSzorp();
            int varos = szorpVaros.getVaros();
            if ( h[sz][2] != 0 ) {
                return false;
            }
            if ( sz == 1 && h[5][1] == 0 ) {
                return false;
            }
            if ( sz != 1 && h[sz - 1][2] == 0 ) {
                return false;
            }
            for ( int i = 1; i < sz; ++i ) {
                if ( h[i][2] == varos ) {
                    return false;
                }
            }
            if ( sz == 4 && varos == SzorpVaros.SOPRON ) {
                return false;
            }
            if ( sz == 2 && varos != SzorpVaros.SOLYMAR ) {
                return false;
            }
            if ( sz == 1 && varos == SzorpVaros.SARVAR ) {
                return false;
            }
            if ( h[sz][1] == SzorpFajta.SZEDER && varos != SzorpVaros.SZOB ) {
                return false;
            }
            return true;
        } else if ( op instanceof SzorpPont ) {
            SzorpPont szorpPont = ( SzorpPont ) op;
            int sz = szorpPont.getSzorp();
            int pont = szorpPont.getPont();
            if ( h[sz][3] != 0 ) {
                return false;
            }
            if ( sz == 1 && h[5][2] == 0 ) {
                return false;
            }
            if ( sz != 1 && h[sz - 1][3] == 0 ) {
                return false;
            }
            for ( int i = 1; i < sz; ++i ) {
                if ( h[i][3] == pont ) {
                    return false;
                }
            }
            if ( sz == 5 && pont != 40 ) {
                return false;
            }
            if ( sz != 5 && pont == 40 ) {
                return false;
            }
            if ( h[sz][1] == SzorpFajta.MALNA && pont != 60 ) {
                return false;
            }
            if ( sz == 4 && pont == 50 ) {
                return false;
            }
            for ( int i = 1; i <= 5; ++i ) {
                if ( h[i][2] == SzorpVaros.SOPRON && h[i][3] != 0 && sz == 4 && pont != h[i][3] - 10 ) {
                    return false;
                }
            }
            if ( h[4][3] != 0 && h[sz][2] == SzorpVaros.SOPRON && pont != h[4][3] + 10 ) {
                return false;
            }
            if ( h[sz][2] == SzorpVaros.SOLYMAR && pont == 50 ) {
                return false;
            }
            if ( h[sz][2] == SzorpVaros.SARVAR && pont != h[1][3] - 30 ) {
                return false;
            }
            return true;
        }
        throw new HibasOperatorException();
    }

    @Override
    public Allapot alkalmaz( Operator op ) throws HibasOperatorException {
        SzorpAllapot uj = new SzorpAllapot( this );
        if ( op instanceof SzorpFajta ) {
            SzorpFajta szorpFajta = ( SzorpFajta ) op;
            int sz = szorpFajta.getSzorp();
            int fajta = szorpFajta.getFajta();
            uj.h[sz][1] = fajta;
        } else if ( op instanceof SzorpVaros ) {
            SzorpVaros szorpVaros = ( SzorpVaros ) op;
            int sz = szorpVaros.getSzorp();
            int varos = szorpVaros.getVaros();
            uj.h[sz][2] = varos;
        } else if ( op instanceof SzorpPont ) {
            SzorpPont szorpPont = ( SzorpPont ) op;
            int sz = szorpPont.getSzorp();
            int pont = szorpPont.getPont();
            uj.h[sz][3] = pont;
        }
        else
            throw new HibasOperatorException();
        return uj;
    }
}
