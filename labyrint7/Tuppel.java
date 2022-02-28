/*
klassen Tuppel ta vare på koordinatene som vi har gaat gjennom
 */

public class Tuppel {
    private int x;     //tilsvarer rad
    private int y;      //kolon

    public Tuppel(int x, int y){
        this.x = x;
        this.y = y;

    }


    public String toString(){

        return "(" + x +","+ y +")";
    }
}
