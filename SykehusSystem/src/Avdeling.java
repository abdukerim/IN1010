public class Avdeling {
    PasientAdm pasienter;
    final void settInn(Pasient p) {
        pasienter.settInnPasient(p);
    }
    final Pasient hentUt(Pasient p) {
        return pasienter.hentUt(p);
    }
    final Pasient hentUt(int i) {

        return pasienter.hentUt(i);
    }

}
