public class Stabel<T> extends Lenkeliste1<T> {
  public Stabel () {

    super();
  }
  public void leggPaa(T x) { //legger elementet enden av listen
    super.leggTil(x);
  }
  public T taAv() {
    return super.fjern(stoerrelse() -1); //fjerner siste element i listen
  }
}
