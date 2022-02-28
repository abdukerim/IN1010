import java.util.ArrayList;

public class Aapning extends HvitRute{

    public Aapning(int r, int k, Labyrint labyrint) {
        super(r, k, labyrint);
    }
    @Override
    public char tilTegn(){
        return '.';
    }

    @Override
    public void gaa(ArrayList<Tuppel> sti,Rute fra){

        ArrayList<Tuppel> nySti = new ArrayList<Tuppel>(sti);
        nySti.add(new Tuppel(xRad, yKolonne));
        //veien slutter her
        labyrint.leggTilUtvei(nySti);
    }
}
