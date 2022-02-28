import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class VirusHoved2 {

    private static final int STORRELSE_SUBSEKVENS = 3;

    public static void main(String[] args) {
        // lese filer
        //metadata.txt sier hvilke filer vi skal bruke
        HashBeholder2 hashBeholder = new HashBeholder2();

        try (Scanner sc = new Scanner(new File("metadata.csv"))) { //tekstfiler/metadata.txt
          String header = sc.nextLine();
            while (sc.hasNext()) {
              //sc.nextLine();
                String[] data = sc.nextLine().split(",");
                String filnavn = data[0]; //String filnavn = "tekstfiler/" + sc.nextLine();

                lesSubsekvensfil(filnavn, hashBeholder);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // har nå lest alle filene

        // ta ut to og to hasmaper, fletter de sammen
        while (hashBeholder.antallHashMaps() > 1){
            HashMap<String, SubSequence> map1 = hashBeholder.taUtEnHashMap();
            HashMap<String, SubSequence> map2 = hashBeholder.taUtEnHashMap();

            HashMap<String, SubSequence> ny = HashBeholder.flett(map1, map2);
            hashBeholder.insertHashMap(ny);
        }

        // nå skal det kun være 1 map i beholderen
        // tar ut en beholder, vet ikke om vi skal sette den inn igjen?
        HashMap<String, SubSequence> map = hashBeholder.taUtEnHashMap();
        int grense = 5;
        map.forEach((key, value) ->
            {
              if(value.antall() > 5)
                  System.out.println(key + ": ");
            }
        );

        System.out.println(map.keySet().size());
    }

    /**
     * Leser subsekvenser fra fil med filnavn og setter inn i beholderen
     * @param filnavn
     * @param hashBeholder
     */
    public static void lesSubsekvensfil(String filnavn, HashBeholder2 hashBeholder){
        try(BufferedReader bf = new BufferedReader(new FileReader(filnavn))){
            HashMap<String, SubSequence> subsekvensMap = new HashMap<String, SubSequence>();
            bf.readLine();
            String linje;
            while ((linje = bf.readLine()) != null) {

                // finner alle subsekvenser på en linje
                for (int i = 0; i < linje.length() - STORRELSE_SUBSEKVENS; i++) {
                    String subsekvens = linje.substring(i, i + STORRELSE_SUBSEKVENS);

                    if (subsekvensMap.containsKey(subsekvens)) {
                        // dersom finnes fra før
                        SubSequence sekv = subsekvensMap.get(subsekvens);
                        sekv.leggTil(1);
                    }
                    else {
                        // dersom ikke finnes fra før


                        subsekvensMap.put(subsekvens, new SubSequence(subsekvens));
                    }
                }
            }
            //hvis ingen feil
            hashBeholder.insertHashMap(subsekvensMap);

        } catch (IOException e) {
            System.out.println("Fant ikke filen: " + filnavn);
            e.printStackTrace();
            System.exit(-1);
        }


    }
}
