public class Sykehus {
    Avdeling akutten,senger;
    void skrivInn(Pasient p,Avdeling a) {
        a.settInn(p);
    }
    void overfor(Pasient p,Avdeling fra,Avdeling til) {
        if(fra.hentUt(p) != null) {
            til.settInn(p);
        }
    }
    void skrivUt(Pasient p,Avdeling fra) {
        fra.hentUt(p);
    }
    static boolean iFaresonenKvinne(Pasient p) {
        return true;
    }
    static boolean iFaresonenMann(Pasient p) {
        return true;
    }
    static void kanHaSykdomKvinne(Pasient p) {

    }
    static void kanHaSykdomMann(Pasient p) {

    }
    static void utForAnalyse(PasientPrio p,int antAnalyser) {
        AnalyseBeholder beholder = new AnalyseBeholder();
        for (int i = 0; i <= Pasient.MAXPASPRIO ; i++) {
            new Thread(new Sil(p,i,beholder)).start();
        }
        for (int i = 1; i <= antAnalyser ; i++) {
            new Thread(new Analyse(beholder)).start();
        }
    }

    public static void main(String[] args) {
        Sykehus ullevaal = new Sykehus();
        ullevaal.akutten = new Akutten();
        ullevaal.senger = new Sengpost(30);
        /*
        Pasient per = new Pasient("Per Hansen","1234567",3);
        Pasient kari = new Pasient("Kari Norman","238726",8);
        Pasient siri = new Pasient("Siri sam","3452343",4);
        ullevaal.skrivInn(per, ullevaal.akutten);
        ullevaal.skrivInn(kari, ullevaal.senger);
        ullevaal.skrivInn(siri, ullevaal.akutten);
        */
    }
}
