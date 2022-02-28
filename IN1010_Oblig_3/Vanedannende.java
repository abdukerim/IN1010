public class Vanedannende extends Legemiddel{

    protected int styrke;

    public Vanedannende(String navn, int pris, double virkeStoff,int styrke) {
        super(navn, pris, virkeStoff);
        this.styrke = styrke;
    }

    public int hentVaneStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return "VaneDannende{" +
                "navn='" + navn + '\'' +
                ", legemiddelID=" + legemiddelID +
                ", pris=" + pris +
                ", virkeStoff=" + virkeStoff +
                ", styrke=" + styrke +
                '}';
    }
}
