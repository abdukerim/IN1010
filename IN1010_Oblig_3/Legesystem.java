import java.io.*;
import java.util.*;

public class Legesystem {
    Lenkeliste1<Pasient> pasienter = new Lenkeliste1<Pasient>();
    SortertLenkeliste2<Lege> leger = new SortertLenkeliste2<Lege>();
    Lenkeliste1<Legemiddel> legemidler = new Lenkeliste1<Legemiddel>();
    Lenkeliste1<Resept> resepter = new Lenkeliste1<Resept>();

    public static void main(String[] args) throws UlovligUtskrift, FileNotFoundException {

        Legesystem ls = new Legesystem();
        ls.hovedMeny();

    }
    public void lesFraFil(String filNavn) throws UlovligUtskrift, FileNotFoundException ,NumberFormatException{
        try {
            File fil = new File(filNavn);
            Scanner les = new Scanner(fil);
            while (les.hasNextLine()) {
                String linjer = les.nextLine();
                try {
                    if(linjer.startsWith("# Pasienter")) {
                        linjer = les.nextLine();
                        while (!linjer.startsWith("#")) {
                            String[] biter = linjer.split(",");
                            Pasient nyPasient = new Pasient(biter[0],biter[1]);
                            pasienter.leggTil(nyPasient);
                            linjer = les.nextLine();
                        }
                    }
                    if (linjer.startsWith("# Legemidler")) {
                        linjer = les.nextLine();
                        while (!linjer.startsWith("#")) {
                            String[] biter = linjer.split(",");
                            if (biter[1] == "narkotisk") {
                                Narkotisk nyNarko = new Narkotisk(biter[0],Integer.parseInt(biter[2]),Double.parseDouble(biter[3]),Integer.parseInt(biter[4]));
                                legemidler.leggTil(nyNarko);
                            }
                            else if (biter[1] == "vanedannende") {
                                Vanedannende nyVane = new Vanedannende(biter[0],Integer.parseInt(biter[2]),Double.parseDouble(biter[3]),Integer.parseInt(biter[4]));
                                legemidler.leggTil(nyVane);
                            }
                            else if (biter[1] == "vanlig") {
                                Vanlig nyVanlig = new Vanlig(biter[0],Integer.parseInt(biter[2]),Double.parseDouble(biter[3]));
                                legemidler.leggTil(nyVanlig);
                            }
                            linjer = les.nextLine();

                        }
                    }

                    if (linjer.startsWith("# Leger")) {
                        linjer = les.nextLine();
                        while (!linjer.startsWith("#")) {
                            String[] biter = linjer.split(",");
                            if(!(biter[1].equals("0"))) {
                                Spesialist nySpes = new Spesialist(biter[0],biter[1]);
                                leger.leggTil(nySpes);
                            }
                            else {
                                Lege nyLege = new Lege(biter[0]);
                                leger.leggTil(nyLege);
                            }
                            linjer = les.nextLine();
                        }
                    }
                    if (linjer.startsWith("# Resepter")) {
                        linjer = les.nextLine();
                        while (!linjer.startsWith("#")) {
                            String[] biter = linjer.split(";");

                            if (biter[3].equals("hvit")) {

                                HvitResept nyHvit = hentLege(biter[1]).skrivHvitResept(hentLegemiddel(biter[0]),
                                        hentPasient(biter[2]),Integer.parseInt(biter[4]));
                                resepter.leggTil(nyHvit);
                            }
                            else if (biter[3].equals("blaa")) {

                                BlaaResept nyBlaa = hentLege(biter[1]).skrivBlaaResept(hentLegemiddel(biter[0]),
                                        hentPasient(biter[2]),Integer.parseInt(biter[4]));
                                resepter.leggTil(nyBlaa);
                            }
                            else if (biter[3].equals("militaer")) {

                                MilitaerResept nyMilitaer = hentLege(biter[1]).skrivMilitaerResept(hentLegemiddel(biter[0]),
                                        hentPasient(biter[2]),Integer.parseInt(biter[4]));
                                resepter.leggTil(nyMilitaer);
                            }
                            else if (biter[3].equals("p")) {

                                PResept nyP = hentLege(biter[1]).skrivPResept(hentLegemiddel(biter[0]),hentPasient(biter[2]));
                                resepter.leggTil(nyP);
                            }
                            linjer = les.nextLine();
                        }
                    }
                }
                catch (IllegalFormatException e) {
                    System.err.println("Feil format");
                }
             }
            les.close();
        }catch (FileNotFoundException e) {
            System.out.println("Finner ikke filen");
            System.exit(1);
        }
    }
    public void hovedMeny() throws UlovligUtskrift{
        System.out.println("****Velkommen til Legesystemet!!***");
        System.out.println("***Hoved Meny***");
        Scanner innput = new Scanner(System.in);
        String tast = null;
        System.out.println("1 for oversikt");
        System.out.println("2 for legge til nye elementer");
        System.out.println("3 for statistikk");
        System.out.println("4 for avslutte programmet");
        if(innput.hasNextLine()) {
            while (tast !="4"){
                tast = innput.nextLine();
                if (tast.equals("1")) {
                    oversikt();
                    hovedMeny();
                }
                else if (tast.equals("2")) {
                    leggTil();
                    hovedMeny();
                }
                else if (tast.equals("3")) {
                    statistikk();
                    hovedMeny();
                }
                else if (tast.equals("4")) {
                    System.out.println("Avslutt");
                    innput.close();
                }
            }
        }

    }
    public void statistikk() {

    }
    public void oversikt() {

    }
    public void leggTil() throws UlovligUtskrift{
        System.out.println("Hva sal du legge til?");
        System.out.println("1 for lege");
        System.out.println("2 for pasien");
        System.out.println("3 for resept");
        System.out.println("4 for legemiddel");
        System.out.println("Enter for gaa tilbake");
        Scanner innput = new Scanner(System.in);
        String tast = null;
        if (innput.hasNextLine()){
            while(tast!=""){
                tast = innput.nextLine();
                if(tast.equals("1")){
                    System.out.println("1 for spesialist");
                    System.out.println("2 for vanlig lege");
                    if (innput.hasNextLine()){
                        tast = innput.nextLine();
                        if(tast.equals("1")){
                            System.out.println("Skriv inn kontroll-ID: ");
                            if (innput.hasNextLine()){
                                String kontrollID = innput.nextLine();
                                if(kontrollID!= null){
                                    System.out.println("Skriv inn legens navn: ");
                                    if (innput.hasNextLine()){
                                        Spesialist nyspes = new Spesialist(innput.nextLine(), kontrollID);
                                        leger.leggTil(nyspes);
                                        System.out.println("Spesialisten ble lagret, press enter for aa gaa tilbake");
                                        if(innput.hasNextLine()){
                                            tast = innput.nextLine();
                                            if(tast.equals("")){
                                                leggTil();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if (tast.equals("2")){
                            System.out.println("Skriv inn legens navn: ");
                            if (innput.hasNextLine()){
                                Lege nyLege = new Lege(innput.nextLine());
                                leger.leggTil(nyLege);
                                System.out.println("Legen ble lagret, press enter for aa gaa tilbake");
                                if(innput.hasNextLine()){
                                    tast = innput.nextLine();
                                    if(tast.equals("")){
                                        leggTil();
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Ugyldig valg. Press enter for aa gaa tilbake");
                            if(innput.hasNextLine()){
                                tast = innput.nextLine();
                                if(tast.equals("")){
                                    leggTil();
                                }
                            }
                        }
                    }
                }
                else if(tast.equals("2")){
                    System.out.println("pasientens navn: ");
                    if (innput.hasNextLine()){
                        String navn = innput.nextLine();
                        if (navn!= null){
                            System.out.println("pasientens fodselsnummer: ");
                            if (innput.hasNextLine()){
                                String fnr = innput.nextLine();
                                if(fnr.length()==11){
                                    Pasient nyPas = new Pasient(navn, fnr);
                                    pasienter.leggTil(nyPas);
                                    System.out.println("Pasienten ble lagret, enter for aa gaa tilbake");
                                    if(innput.hasNextLine()){
                                        tast = innput.nextLine();
                                        if(tast.equals("")){
                                            leggTil();
                                        }
                                    }
                                }
                                else{
                                    System.out.println("Feil! Tast inn riktig nummer ");
                                    if (innput.hasNextLine()){
                                        fnr = innput.nextLine();
                                        if(fnr.length()==11){
                                            Pasient nyPas = new Pasient(navn, fnr);
                                            pasienter.leggTil(nyPas);
                                            System.out.println("Pasienten ble lagret, enter for aa gaa tilbake");
                                            if(innput.hasNextLine()){
                                                tast = innput.nextLine();
                                                if(tast.equals("")){
                                                    leggTil();
                                                }
                                            }
                                        }
                                        else{
                                            System.out.println("Ugyldig tast. Press enter for aa gaa tilbake ");
                                            if(innput.hasNextLine()){
                                                tast = innput.nextLine();
                                                if(tast.equals("")){
                                                    leggTil();
                                                }
                                                else{
                                                    leggTil();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                else if(tast.equals("3")){
                    Lege nyLege = null;
                    while(nyLege == null && tast!=""){
                        System.out.println("legens navn: ");
                        if (innput.hasNextLine()){
                            String navn = innput.nextLine();
                            if (navn!= null){
                                nyLege = hentLege(navn);
                                if (nyLege != null){
                                    break;
                                }
                                else{
                                    System.out.println("Finner ikke legen. proev igjen");
                                    if (innput.hasNextLine()){
                                        tast = innput.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    Legemiddel nyLm = null;
                    while(nyLm == null && tast!=""){
                        System.out.println("Skriv legemiddelets navn : ");
                        if (innput.hasNextLine()){
                            String navn = innput.nextLine();
                            if (navn!= null){
                                nyLm = hentLegemiddel(navn);
                                if (nyLm != null){
                                    break;
                                }
                                else{
                                    System.out.println("Finner ikke legemiddelet. Trykk Enter for aa proeve igjen");
                                    if (innput.hasNextLine()){
                                        tast = innput.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    Pasient nyPas = null;
                    while(nyPas == null && tast!=""){
                        System.out.println("Pasient ID eller navnet: ");
                        if (innput.hasNextLine()){
                            String  pas = innput.nextLine();
                            if(pas!= null){
                                nyPas = hentPasient(pas);
                                if (nyPas != null){
                                    break;
                                }
                                else{
                                    System.out.println("Finner ikke pasienten. Trykk Enter for aa proeve igjen\"");
                                    if (innput.hasNextLine()){
                                        tast = innput.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    String resType = null;
                    while(resType == null && tast!=""){
                        System.out.println("Hvilke type resept vil du legge inn?");
                        System.out.println("1 for Hvit");
                        System.out.println("2 for Blaa");
                        System.out.println("3 for P resept");
                        System.out.println("4 for Militaer");

                        if (innput.hasNextLine()){
                            String valg = innput.nextLine();
                            if (valg.equals("1") || valg.equals("2")|| valg.equals("3") || valg.equals("4")){
                                resType = valg;
                            }
                            /*else if (valg.equals("")){
                                type = input;
                            }
                            else if (input.equals("p")){
                                type = input;
                            }
                            else if (input.equals("m")){
                                type = input;
                            }*/
                            else{
                                System.out.println("Ugyldig resept type. trykk enter for aa rov igjen.");
                            }
                        }
                    }
                    if (resType.equals("3")){
                        nyLege.skrivPResept(nyLm, nyPas);
                        System.out.println("Resepten ble lagert, trykk enter for aa gaa tilbake.");
                        if (innput.hasNextLine()){
                            tast = innput.nextLine();
                        }
                    }
                    else{
                        int reit = 0;
                        while(reit == 0 && tast!=""){
                            System.out.println("Antall reit resepten skal ha:  ");
                            if (innput.hasNextLine()){
                                String n = innput.nextLine();
                                if (n!= null){
                                    try {
                                        int num = Integer.parseInt(n);
                                        reit = num;
                                    }catch (NumberFormatException e) {
                                        System.out.println("Feil tast, prov igjen.");
                                        if (innput.hasNextLine()){
                                            tast = innput.nextLine();
                                        }
                                    }
                                }
                            }
                        }
                        if(resType.equals("1")){
                            nyLege.skrivHvitResept(nyLm, nyPas, reit);
                        }
                        else if(resType.equals("2")){
                            nyLege.skrivBlaaResept(nyLm, nyPas, reit);
                        }
                        else if(resType.equals("4")){
                            nyLege.skrivMilitaerResept(nyLm, nyPas, reit);
                        }
                    }
                }
                else if(tast.equals("4")){
                    String lmType = null;
                    int pris = 0;
                    double virkestoff = 0;
                    int styrke = 0;
                    String navn = null;

                    System.out.println("legemiddelets navn: ");
                    if(innput.hasNextLine()){
                        navn = innput.nextLine();
                    }
                    while(lmType == null && tast!=""){
                        System.out.println("Velg Preparat type");
                        System.out.println("1 for vanlig");
                        System.out.println("2 for vanedannende");
                        System.out.println("3 for narkotika");

                        if (innput.hasNextLine()){
                            String inn = innput.nextLine();
                            if (inn!= null){
                                if (inn.equals("1") || inn.equals("2") || inn.equals("3")){
                                    lmType = inn;
                                }
                                else{
                                    System.out.println("Ugyildig tast. Prov igjen.");
                                }
                            }
                        }
                    }
                    while(pris == 0 && tast !=""){
                        System.out.println("Pris : ");
                        if (innput.hasNextLine()){
                            String n = innput.nextLine();
                            if (n!= null){
                                try {
                                    int num = Integer.parseInt(n);
                                    pris = num;
                                }catch (NumberFormatException e) {
                                    System.out.println("Feil melding. Ugyildig tast. prov igjen");
                                    if (innput.hasNextLine()){
                                        tast = innput.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    while(virkestoff==0 && tast !=""){
                        System.out.println("Virkestoff innholdet : ");
                        if (innput.hasNextLine()){
                            String n = innput.nextLine();
                            if (n!= null){
                                try {
                                    double num = Double.parseDouble(n);
                                    virkestoff = num;
                                }catch (NumberFormatException e) {
                                    System.out.println("Ugyldig tast, prov igjen.");
                                    if (innput.hasNextLine()){
                                        tast = innput.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    if(lmType.equals("1")){
                        Vanlig nyVanlig = new Vanlig(navn, pris, virkestoff);
                        legemidler.leggTil(nyVanlig);
                        System.out.println("Legemiddelet ble lagret");

                    }
                    else{
                        while(styrke==0){
                            System.out.println("Styrken paa legemiddelet:  ");
                            if (innput.hasNextLine()){
                                String n = innput.nextLine();
                                if (n!= null){
                                    try {
                                        int num = Integer.parseInt(n);
                                        styrke = num;
                                    }catch (NumberFormatException e) {
                                        System.out.println("Ugyldig tast, prov igjen.");
                                        if (innput.hasNextLine()){
                                            tast = innput.nextLine();
                                        }
                                    }
                                }
                            }
                        }
                        if(lmType.equals("2")){
                            Vanedannende nyVane = new Vanedannende(navn, pris, virkestoff, styrke);
                            legemidler.leggTil(nyVane);
                        }
                        else if(lmType.equals("3")){
                            Narkotisk nyNarko = new Narkotisk(navn, pris, virkestoff, styrke);
                            legemidler.leggTil(nyNarko);
                        }
                        System.out.println("Legemiddelet ble lagret. Enter for aa gaa tilbake ");
                        if (innput.hasNextLine()){
                            tast = innput.nextLine();
                        }
                    }
                }
                hovedMeny();
            }
            innput.close();
        }
    }
    public void skrivUtAlt() {
        for (Pasient p : pasienter) {
            System.out.println(p.toString());

        }
        for (Lege l : leger) {
            System.out.println(l.toString());

        }
        for (Resept r : resepter) {
            System.out.println(r.toString());

        }
        for (Legemiddel lm : legemidler) {
            System.out.println(lm.toString());

        }


    }
    public Lege hentLege(String legeNavn) {
        for(Lege l : leger) {
            if(l.hentNavn().equals(legeNavn)) {
                return l;
            }
        }
        return null;
    }
    public Legemiddel hentLegemiddel(String legemiddelNavn) {
        for (Legemiddel lm : legemidler) {
            if (lm.hentNavn().equals(legemiddelNavn)) {
                return lm;
            }

        }
        return null;
    }
    public Pasient hentPasient(String pasient) {
        for (Pasient p : pasienter) {
            if(p.hentPasId() == Integer.parseInt(pasient)) {
                return  p;
            }
            else if (p.hentNavn().equals(pasient)) {
                return p;
            }
        }
        return  null;
    }


}
