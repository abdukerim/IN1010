public class Pasient {
    protected String navn;
    protected String fodselsnummer;
    protected static int count;
    protected int pasId = count;
    public Stabel<Resept> pasResepter;

    public Pasient(String navn, String fnr) {
        this.navn = navn;
        fodselsnummer = fnr;
        pasResepter = new Stabel<Resept>();
        count++;
        pasId = count;

    }

    public String hentNavn() {
        return navn;
    }

    public String hentFodselsnummer() {
        return fodselsnummer;
    }


    public int hentPasId() {
        return pasId;
    }

    public Stabel<Resept> hentPasResepter() {
        return pasResepter;
    }
    public void leggTilResept(Resept res) {
        pasResepter.leggPaa(res);
    }

    @Override
    public String toString() {
        return "Pasient{" +
                "navn='" + navn + '\'' +
                ", fodselsnummer='" + fodselsnummer + '\'' +
                ", pasId=" + pasId +
                ", pasResepter=" + pasResepter +
                '}';
    }
}
