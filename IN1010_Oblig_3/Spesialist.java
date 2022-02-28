public class Spesialist extends Lege implements Godkjenningsfritak{
    protected String kontrollID;

    public Spesialist(String legeNavn, String kontrollID) {
        super(legeNavn);
        this.kontrollID = kontrollID;
        utskrevedeResepter = new Lenkeliste1<Resept>();
    }
    public String hentKontrollID() {
        return kontrollID;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        return super.skrivHvitResept(legemiddel, pasient, reit);
    }

    @Override
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        return super.skrivBlaaResept(legemiddel, pasient, reit);
    }

    @Override
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        return super.skrivPResept(legemiddel, pasient);
    }

    @Override
    public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        return super.skrivMilitaerResept(legemiddel, pasient, reit);
    }
	@Override
	public String hentKonrollID() {
		// TODO Auto-generated method stub
		return null;
	}
}
