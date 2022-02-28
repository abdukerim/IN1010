public class Sil implements Runnable{
    PasientPrio pasienter;
    int prioritet;
    AnalyseBeholder tilAnalyse;

    public Sil(PasientPrio pasienter, int prioritet, AnalyseBeholder tilAnalyse) {
        this.pasienter = pasienter;
        this.prioritet = prioritet;
        this.tilAnalyse = tilAnalyse;
    }

    @Override
    public void run() {
        Pasient p = pasienter.hentUt(prioritet);
        while (p != null) {
            if(p.iFaresonen()) {
                try {
                    tilAnalyse.leggInn(p);
                }
                catch (InterruptedException e) {

                }

            }
            p = pasienter.hentUt(prioritet);
        }
    }
}
