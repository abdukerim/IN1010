public class PasientTabell extends PasientAdm{ //prioko i array
    Pasient[] senger;
    int letPos = 0;

    public PasientTabell(int antallSenger) {
        senger = new Pasient[antallSenger];
    }

    @Override
    void settInnPasient(Pasient p) {
        int startPosisjon = letPos;
        while (true) {
            if(senger[letPos] == null) {
                senger[letPos] = p;
                p.sengNr = letPos;
                return;
            }
            letPos++;
            if(letPos >= senger.length) {
                letPos = 0;

            }
            if(letPos == startPosisjon) {
                return;
            }
        }

    }

    @Override
    Pasient hentUt(Pasient p) {
        senger[p.sengNr] = null;
        p.sengNr = -1;
        return p;
    }

    @Override
    Pasient hentUt(int i) {
        for (int j = 0; j < senger.length; j++) {
            if(senger[j] != null && senger[j].prioritet == i) {
                Pasient denne = senger[j];
                denne.sengNr = -1;
                senger[j] = null;
                return denne;
            }
        }
        return null;
    }
}
