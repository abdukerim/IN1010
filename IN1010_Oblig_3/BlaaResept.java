public class BlaaResept extends  Resept{

    public BlaaResept(Legemiddel legemiddel, Lege utskrevendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrevendeLege, pasient, reit);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String farge() {
        return "Blaa";
    }

    @Override
    public int prisAaBetale() {
        return (int) (legemiddel.hentPris() * 0.25);
    }
}

