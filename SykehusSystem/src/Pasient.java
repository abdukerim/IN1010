abstract class Pasient {
    final String fnr;
    final String navn;
    Pasient neste;
    final static int MAXPASPRIO = 10;
    int prioritet; //0 <= prioritet <= 10
    int sengNr = -1;
    abstract boolean iFaresonen();
    abstract void kanHaSykdom();

    public Pasient(String navn, String fnr, int prioritet) {
        this.fnr = fnr;
        this.navn = navn;
        this.prioritet = prioritet;
    }

}
