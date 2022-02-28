
public class MilitaerResept extends HvitResept {

    public MilitaerResept(Legemiddel legemiddel, Lege utskrevendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrevendeLege, pasient, reit);
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
