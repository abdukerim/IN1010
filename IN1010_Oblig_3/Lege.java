public class Lege implements Comparable<Lege> {
    protected  String legeNavn;
    Lenkeliste1<Resept> utskrevedeResepter;
    protected int antUtNarko;

    public Lege(String legeNavn) {
        this.legeNavn = legeNavn;
        utskrevedeResepter = new Lenkeliste1<Resept>();
    }

    public String hentNavn() {
        return legeNavn;
    }

    @Override
    public String toString() {
        return "Lege{" +
                "legeNavn='" + legeNavn + '\'' +
                '}';
    }

    public int compareTo(Lege l) {
        return legeNavn.compareTo(l.hentNavn());
    }

    public Lenkeliste1<Resept> hentUtskrevedeResepter() {
        return utskrevedeResepter;
    }
    public HvitResept skrivHvitResept(Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this,legemiddel);
        }
        HvitResept nyHvitResept = new HvitResept(legemiddel,this,pasient,reit);
        pasient.leggTilResept(nyHvitResept);
        utskrevedeResepter.leggTil(nyHvitResept);
        return nyHvitResept;

    }
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this,legemiddel);
        }
        BlaaResept nyBlaaResept = new BlaaResept(legemiddel,this,pasient,reit);
        pasient.leggTilResept(nyBlaaResept);
        utskrevedeResepter.leggTil(nyBlaaResept);
        return nyBlaaResept;

    }
    public PResept skrivPResept(Legemiddel legemiddel,Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this,legemiddel);
        }
        PResept nyPResept = new PResept(legemiddel,this,pasient);
        pasient.leggTilResept(nyPResept);
        utskrevedeResepter.leggTil(nyPResept);
        return nyPResept;

    }
    public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this,legemiddel);
        }
        MilitaerResept nyMilitaerResept = new MilitaerResept(legemiddel,this,pasient,reit);
        pasient.leggTilResept(nyMilitaerResept);
        utskrevedeResepter.leggTil(nyMilitaerResept);
        return nyMilitaerResept;

    }
}