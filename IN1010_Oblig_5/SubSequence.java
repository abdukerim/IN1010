class SubSequence {
	private String sequence;
	private int occurences = 1;
	SubSequence (String s) {sequence = s;}
	// public void addOne ( ) {occurences++;}
	public String nokkel() {return sequence;}
	public int antall () {return occurences;}
	public void leggTil(int ant) {occurences = occurences + ant;}
}


/*
class SubSekvens{
    private String subSekvens;
    private int antallForekomst = 1;
    public SubSekvens(String s) {
        subSekvens = s;
    }
    public void setSubSekvens(String nySubsekvens) {
        subSekvens = nySubsekvens;
    }
    public String hentSubsekvens() {
        return subSekvens;
    }

    public void setAntall(int antall) {
        antallForekomst = antall;
    }

    public String nokkel() {
        return subSekvens;
    }
    public int hentAntall() {
        return antallForekomst;
    }
    public void oekAntall(int ant) {
        antallForekomst += ant;
    }
}
*/
