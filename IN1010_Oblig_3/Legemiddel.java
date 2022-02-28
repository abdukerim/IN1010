public class Legemiddel {
    protected String navn;
    protected int legemiddelID = 0;
    protected int pris;
    protected static int count;
    protected  double virkeStoff;


    public Legemiddel(String navn, int pris, double virkeStoff) {
        count++;
        this.navn = navn;
        legemiddelID = count;
        this.pris = pris;
        this.virkeStoff = virkeStoff;

    }

    public String hentNavn() {
        return navn;
    }

    public int hentID() {
        return legemiddelID;
    }

    public int hentPris() {
        return pris;
    }


    public double hentVirkeStoff() {
        return virkeStoff;
    }

    @Override
    public String toString() {
        return "Legemiddel{" +
                "navn='" + navn + '\'' +
                ", legemiddelID=" + legemiddelID +
                ", pris=" + pris +
                ", virkeStoff=" + virkeStoff +
                '}';
    }
}
