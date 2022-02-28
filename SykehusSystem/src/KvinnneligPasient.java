public class KvinnneligPasient extends Pasient{
    public KvinnneligPasient(String navn, String fnr, int prioritet) {
        super(navn, fnr, prioritet);
    }

    @Override
    boolean iFaresonen() {
        return Sykehus.iFaresonenKvinne(this);
    }

    @Override
    void kanHaSykdom() {
        Sykehus.kanHaSykdomKvinne(this) ;
    }
}
