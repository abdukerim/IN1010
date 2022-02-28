public class MannligPasient extends Pasient{
    public MannligPasient(String navn, String fnr, int prioritet) {
        super(navn, fnr, prioritet);
    }

    @Override
    boolean iFaresonen() {
        return Sykehus.iFaresonenMann(this);
    }

    @Override
    void kanHaSykdom() {
        Sykehus.kanHaSykdomMann(this) ;
    }

}
