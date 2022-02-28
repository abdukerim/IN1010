
public class Narkotisk extends Legemiddel{
    protected  int styrke;

    public Narkotisk(String navn, int pris, double virkeStoff,int styrke) {
        super(navn, pris, virkeStoff);
        this.styrke = styrke;
    }

    public int hentNarkoStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return "Narkotisk{" +
                "navn='" + navn + '\'' +
                ", legemiddelID=" + legemiddelID +
                ", pris=" + pris +
                ", virkeStoff=" + virkeStoff +
                ", styrke=" + styrke +
                '}';
    }
}