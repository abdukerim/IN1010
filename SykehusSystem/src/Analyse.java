public class Analyse implements Runnable{
    AnalyseBeholder beholder;

    public Analyse(AnalyseBeholder beholder) {
        this.beholder = beholder;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Pasient p = beholder.hentUt();
                p.kanHaSykdom();
            }
            catch (InterruptedException e) {

            }
        }
    }
}
