import java.util.ArrayList;

public class SortRute extends Rute {

    public SortRute(int r, int k, Labyrint labyrint) {
        super(r, k, labyrint);
    }

    @Override
    public char tilTegn(){
        return '#';
    }

    @Override
    public void gaa(ArrayList<Tuppel> vei,Rute fra){
        //vi gaar ikke sorteRuter
    }
}
