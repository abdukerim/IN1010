import java.util.HashMap;
import java.util.LinkedList;

public class HashBeholder2 {
    private LinkedList<HashMap<String, SubSequence>> subsekvenser = new LinkedList<HashMap<String, SubSequence>>();

    public void insertHashMap(HashMap<String, SubSequence> map){
        subsekvenser.add(map);
    }

    public HashMap<String, SubSequence> taUtEnHashMap(){
        return subsekvenser.pop();
    }

    public int antallHashMaps(){
        return subsekvenser.size();
    }

    static HashMap<String,SubSequence> flett (HashMap<String,SubSequence> subSeqHash1,
                                              HashMap<String,SubSequence>  subSeqHash2){
        SubSequence hentaSub;
        HashMap<String,SubSequence> subSeqHashNy = new HashMap<String,SubSequence> ();
        for(SubSequence  sub1:  subSeqHash1.values()) {
            hentaSub = subSeqHash2.remove(sub1.nokkel());
            if (hentaSub == null) {
                subSeqHashNy.put(sub1.nokkel(), sub1);
            }
            else {
                int ant = hentaSub.antall();
                sub1.leggTil(ant);
                subSeqHashNy.put(sub1.nokkel(), sub1);
            }
        }
        // Legger inn resten av subSeqHash2:
        for(SubSequence  sub2:  subSeqHash2.values()) {
            subSeqHashNy.put(sub2.nokkel(),sub2);
        }
        return 	subSeqHashNy;
    }


    /*// sånn her kan du også gjøre det
    public static HashMap<String, SubSequence> flett(HashMap<String, SubSequence> map1, HashMap<String, SubSequence> map2) {
        // kopierer første hashmap
        HashMap<String, SubSequence> ny = new HashMap<String, SubSequence>(map1);
        // merger hashmap
        map2.forEach((key, value) ->
                ny.merge(key, value, (v1, v2) -> {
                    //merge-strategi
                    if(v1.nokkel().equals(v2.nokkel())){
                        //dersom like
                        v1.leggTil(v2.antall());
                        return v1;
                    }else{
                        return v1;
                    }
                }
                )
        );
        return map2;
    }*/
}
