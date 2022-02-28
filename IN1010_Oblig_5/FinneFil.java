import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class FinneFil {
   public static void main(String[] args) {
     try (Scanner sc = new Scanner(new File("metadata.csv"))) { //tekstfiler/metadata.txt
         String header = sc.nextLine();
         while (sc.hasNext()) {
           //sc.nextLine();
             String[] data = sc.nextLine().split(",");
             String filnavn = data[0]; //String filnavn = "tekstfiler/" + sc.nextLine();

             System.out.println("" +filnavn);
         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
   }
}
