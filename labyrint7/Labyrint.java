import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Labyrint {

    Rute[][] ruter;
    int antRader;
    int antKolonner;
    ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<>();



    public Labyrint(File fil) throws FileNotFoundException{  //kaster videre til main til aa haandtere
        Scanner innlesing = new Scanner(fil);
        String[] header = innlesing.nextLine().split(" "); //foerste linje som gir stoerrelsen
        antRader = Integer.parseInt(header[0]);
        antKolonner = Integer.parseInt(header[1]);
        ruter = new Rute[antRader][antKolonner];
        for (int rad = 0 ; rad < antRader ; rad ++){
            char[] tegn = innlesing.nextLine().toCharArray();  //ukes oeving
            for (int kol = 0 ; kol < antKolonner ; kol++){
                Rute nyRute;
                if(tegn[kol] == '.') {
                    //hvis '.' er forste eller siste rader eller kolonner
                    if (rad == 0 || rad == antRader - 1 || kol == 0 || kol == antKolonner - 1){
                        //saa er det aapning
                        nyRute = new Aapning(rad , kol ,this);
                    }else{
                        //ellers hvitRute
                        nyRute = new HvitRute(rad, kol, this);
                    }
                }else{
                    //hvis ikke '.', saa er det sort rute
                    nyRute = new SortRute(rad, kol, this);
                }
                ruter[rad][kol] = nyRute;

            }
        }
        //setter naborutene etter direction
        //Vi ser i filen at alle ytterste kantene er sorteRuter, dermed trenger vi ikke sette naboer
        //til de ytterste rutene, fordi vi skal bruke disse for aa implmentere gaa() metoden.
        for (int i = 1; i < antRader -1 ; i++) {
            for (int j = 1; j < antKolonner - 1; j++) {
                ruter[i][j].nord = ruter[i - 1][j]; //nord naboer, en rad opp
                ruter[i][j].sor = ruter[i + 1][j];  // soer naboer, en rad ned
                ruter[i][j].vest = ruter[i][j - 1];  //en kolon venstre
                ruter[i][j].ost = ruter[i][j + 1];   // en kolon hoyre

            }
        }
        System.out.println(this.toString());


    }

    /*
    Lag deretter metoden finnUtveiFra(int kol, int rad) i Labyrint. Denne skal kalle på finnUtvei() i
    den ruta som ligger på (int kol, int rad) i labyrinten
     */
    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int x, int y){ //finner utveien fra gitte koordinator
        utveier.clear();  //fjerner forrige utveier
        ruter[x][y].finnUtvei(); //kaller vi metoden fra Rute klassen
        if(utveier.size() == 0) {   //hvis bruker taster inn koordinator fra sorte rute
            System.out.println("Det finnes ikke utvei");
        } else {
            System.out.println("Det finnes " + utveier.size() + " utvei(er)"); //antall utveier
        }
        return utveier;
    }

    public void leggTilUtvei(ArrayList<Tuppel> vei){
        utveier.add(vei);
    }

    @Override
    public String toString(){  //skriv ut hele labyrinten
        String skriv = "";

        for (Rute[] rad : ruter) {   //hver rad
            for (Rute cell : rad) {     //hver celel
                skriv += cell.tilTegn();   //blir det liksom "#",
            }
            skriv += "\n"; //nye linjer etter hver rad
        }
        return skriv;

    }
}
