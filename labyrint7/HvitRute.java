//har faat godt nyttig av loese ukes oppgaver

import java.util.ArrayList;
public class HvitRute extends Rute {

    public HvitRute(int r, int k, Labyrint labyrint) {
        super(r, k, labyrint);
    }

    @Override
    public char tilTegn(){
        return '.';
    }

    @Override
    public void gaa(ArrayList<Tuppel> sti,Rute fra){
        besokt = true;    //sjekker om vi har vaert ruten

        ArrayList<Tuppel> nySti = new ArrayList<Tuppel>(sti);
        nySti.add(new Tuppel(xRad, yKolonne));

        if (nord != fra && !nord.besokt) {  //sjekker om nabo-rutene er den ruten fra, og vi har vaert der
           nord.gaa(nySti,this);
         }
        if (sor != fra && !sor.besokt) {
           sor.gaa(nySti,this);
         }
        if (vest != fra && !vest.besokt) {
          vest.gaa(nySti,this);
        }
        if (ost != fra && !ost.besokt) {
          ost.gaa(nySti,this);
        }

    }
}
