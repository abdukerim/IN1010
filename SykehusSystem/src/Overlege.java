public class Overlege extends Lege{
    final String spesialisering;

    public Overlege(String ansattId, String navn, int legeNr, String spesialisering) {
        super(ansattId, navn, legeNr);
        this.spesialisering = spesialisering;
    }
}
