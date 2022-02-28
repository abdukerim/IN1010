import java.util.Iterator;
public class Lenkeliste1<T> implements Liste<T> {

	protected int lengde = 0;
 	protected Node start;  //lit usikker paa om disse skulle hatt null som verdi
	protected Node slutt;

 //inner klassen Node
	protected class Node {
		 public T ting;
		 public Node neste;


		 public Node(T ting) {
				 this.ting = ting;
		 }
		 public String tosString() {
			 return ting.toString();
		 }
	 }
	 public Node start() {
		 return start;
	 }
	 public boolean erTom() {
		 return start == null;
	 }


	 public void leggTil(int pos, T x) {
		 Node ny = new Node(x);

		 if (erTom() && pos ==1) {
			throw new UgyldigListeIndeks(pos);
		 } else if (erTom()) {
			 start = ny;
			 lengde++;
		 } else if (pos > lengde || pos < 0) {
			 throw new UgyldigListeIndeks(pos);
		 } else if (pos == 0) {
			 Node denne = start;
			 start = ny;
			 ny.neste = denne;
			 lengde ++;
		 } else if (pos == lengde) {
			 slutt.neste = ny;
			 slutt = ny;
			 lengde++;
		 } else {
			 Node n = start;
			 for (int i = 0; i < (pos -1);i++) {
				 n= n.neste;
			 }
			 Node denne = n.neste;
			 n.neste = ny;
			 ny.neste = denne;
			 lengde++;
		 }
	 }


	 //legger noder i slutten av listen
	 public void leggTil(T x) {
		 Node ny = new Node(x);
		 if(erTom()) {
			 start = ny;
			 slutt = ny;
		 }
		 else if (slutt == null){
			 slutt = ny;
		 }
		 else {
			 slutt.neste = ny;
		 }
		 slutt = ny;
		 lengde ++;
	 }


	 //setter inn node i gitte posisjon
	 public void sett(int pos, T x){
		 Node ny = new Node(x);
		 if (erTom()) {
			throw new UgyldigListeIndeks(pos);
		 } else if (pos >= lengde || pos < 0) {
			 throw new UgyldigListeIndeks(pos);
		 } else if (pos == 0) {
			 Node denne = start.neste;
			 start = ny;
			 ny.neste = denne;
		 } else if (pos == lengde) {
			 slutt.neste = ny;
		 } else {
			 Node n = start;
			 for (int i = 0; i < (pos -1);i++) {
				 n= n.neste;
			 }
			 Node denne = n.neste.neste;
			 n.neste = ny;
			 ny.neste = denne;

		 }
	 }

	 //henter noden etter gitte posisjon
	 public T hent(int pos) {
		 if(erTom()) {
			 throw new UgyldigListeIndeks(pos);
		 } else if (pos < 0 || pos >= lengde) {
			 throw new UgyldigListeIndeks(pos);
		 }
		 T ting;
		 if(pos == 0) {
			 ting = start.ting;
		 } else if (pos == lengde - 1) {
			 ting = slutt.ting;
		 } else {
			 Node n = start;
			 for (int i = 0; i < pos; i++){
				 n= n.neste;
	          }
			 ting = n.ting;

		 }
		 return ting;

	 }


	 //fjerner node etter gitte posisjon.
	 public T fjern(int pos) {
		 T ting;
	     if (this.erTom()){
	    	 throw new UgyldigListeIndeks(-1);
	        } else if (pos < 0 || pos >= lengde){
	        	throw new UgyldigListeIndeks(pos);
	        } else if(pos == 0){
	        	ting = this.fjern();
	        } else if(pos == lengde - 1){
	            Node n = start;
	            while (n.neste.neste != null){
	                n = n.neste;
	            }
	            ting = n.neste.ting;
	            slutt = n;
	            slutt.neste = null;
	            lengde --;
	        } else {
	            Node n = start;
	            for (int i = 0; i < pos-1; i++){
	                n = n.neste;
	            }
	            ting = n.neste.ting;
	            n.neste = n.neste.neste;
	            lengde --;
	        }
	        return ting;

	 }


	 //fjerner forste noden, returner dens verdi
	 public T fjern() {
		 if (erTom()) {
			 throw new UgyldigListeIndeks(-1);
		 } else {
			 T ting = start.ting;
			 if(lengde == 1) {
				 start = null;
				 slutt = null;
			 } else {
				 start = start.neste;
			 }
			 lengde --;
			 return ting;
		 }
	 }

	 public int stoerrelse(){
			 return lengde;
	 }

	 public Iterator<T> iterator() {
			 return new LenkelisteIterator(this);
	 }

	 public class LenkelisteIterator implements Iterator<T>{

		 T x;
		 Node n = new Node(x);

		 public LenkelisteIterator(Lenkeliste1<T> l){
				 n.neste = l.start;
		 }

		 public boolean hasNext(){
			 if(n == null) {
				 return false;
			 }
			 if (n.neste == null) {
				 return false;
			 }else {
				 return true;
			 }

		 }

			 public T next(){
				 n = n.neste;
				 return n.ting;
			 }

	 }

}
