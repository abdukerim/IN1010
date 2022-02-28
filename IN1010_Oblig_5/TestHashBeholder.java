//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;


public class TestHashBeholder {

    public static void main(String[] args) {
        testFlett();
    }

    public static void testFlett(){

        SubSequence sub1 = new SubSequence("ABC");
        SubSequence sub2 = new SubSequence("BCA");
        HashMap<String, SubSequence> map1 = new HashMap<String, SubSequence>();
        map1.put(sub1.nokkel(), sub1);
        map1.put(sub2.nokkel(), sub2);

        SubSequence sub3 = new SubSequence("ABC");
        SubSequence sub4 = new SubSequence("BDE");
        HashMap<String, SubSequence> map2 = new HashMap<String, SubSequence>();
        map2.put(sub3.nokkel(), sub3);
        map2.put(sub4.nokkel(), sub4);

        //fletter nå de to med nøkler
        //1: ABC BCA
        //2: ABC BDE
        HashMap<String, SubSequence> nyMap = HashBeholder.flett(map1, map2);
        // skal nå ha ett nytt map med nøkler
        // ABC BCA BDE
        // antallet på ABC skal også være 2
        //assert("Inneholder ABC");
        assert(nyMap.containsKey("ABC"));
        assert(2 == nyMap.get("ABC").antall());
        assert(nyMap.containsKey("BCA"));
        assert(nyMap.containsKey("BDE"));
        assert(3 == nyMap.keySet().size());

    }
}
