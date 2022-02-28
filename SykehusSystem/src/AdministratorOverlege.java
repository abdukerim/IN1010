public class AdministratorOverlege extends Overlege implements Administrator{
    String ansvarskode;

    public AdministratorOverlege(String ansattId, String navn, int legeNr,
                                 String spesialisering, String ansvarskode) {
        super(ansattId, navn, legeNr, spesialisering);
        this.ansvarskode = ansvarskode;
    }

    @Override
    public String finnAnsavr() {
        return ansvarskode;
    }
}
