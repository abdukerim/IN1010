public class PasientPrio extends PasientAdm{
    Pasient[] prioStart = new Pasient[Pasient.MAXPASPRIO+1];
    Pasient[] prioSist = new Pasient[Pasient.MAXPASPRIO+1];
    @Override
    void settInnPasient(Pasient p) {
        int i = p.prioritet;
        if(prioStart[i] == null) {
            prioStart[i] = p;
        }
        else {
            prioSist[i].neste = p;
        }
        prioSist[i] = p;
        p.neste = null;
    }

    @Override
    Pasient hentUt(Pasient p) {
        int i = p.prioritet;
        Pasient tmp = prioStart[i];
        if(tmp == null) {
            return  null;
        }
        if(tmp == p) {
            prioStart[i] = p.neste;
            if(prioStart[i] == null) prioSist[i] = null;
            return p;
        }
        while (true) {
            Pasient tmp2 = tmp.neste;
            if(tmp2 == null) {
                return  null;
            }
            if(tmp2 == p) {
                tmp.neste = tmp2.neste;
                if(prioSist[i] == tmp2) {
                    prioSist[i] = tmp;
                    return tmp2;
                }
            }
            return tmp2;
        }

    }

    @Override
    Pasient hentUt(int i) {
        return hentUt(prioStart[i]);
    }
}
