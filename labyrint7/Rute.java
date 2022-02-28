import java.util.ArrayList;

public abstract class Rute {
    protected int xRad;
    protected int yKolonne;
    protected Labyrint labyrint;

    Rute nord,sor,ost,vest;   //nabo ruter
    boolean besokt = false;


    protected Rute(int r, int k, Labyrint labyrint){
        xRad = r;
        yKolonne = k;
        this.labyrint = labyrint;
    }


    abstract char tilTegn();


    public void finnUtvei(){

        gaa(new ArrayList<>(),null);
    }

    /*
    Metoden gaa() skal implementeres forskjellig i alle Rutes
    subklasser. Når Aapning, SortRute og HvitRute har hver sine tolkninger av metoden gaa()
    trenger vi ikke å bruke instanceof, eller char tilTegn().
    Da kan vi gjore det abstrakt, og la bare hviteRuter gaa, og plusser paa hver koordinator


     */
    abstract void gaa(ArrayList<Tuppel> vei, Rute fra);
    /*
    {
    ArrayList<Tuppel> nySti = new ArrayList<Tuppel>(sti, this);
    nySti.add(new Tuppel(xRad, yKolonne));

    if (nord != fra) {
       nord.gaa(nySti,this);
     }
    if (sor != fra) {
       sor.gaa(nySti,this);
     }
    if (vest != fra) {
      vest.gaa(nySti,this);
    }
    if (ost != fra) {
      ost.gaa(nySti,this);
    }
    }*/

}
