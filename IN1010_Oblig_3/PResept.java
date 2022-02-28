
public class PResept extends HvitResept {
    protected int pReit = 3;

    public PResept(Legemiddel legemiddel, Lege utskrevendeLege, Pasient pasient) {
        super(legemiddel, utskrevendeLege, pasient,3);

    }

    @Override
    public int prisAaBetale() {
        if ((legemiddel.hentPris() - 108) <= 0) {
            return 0;
        } else {
            return (legemiddel.hentPris() - 108);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
