package gui;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Beschreiben Sie hier die Klasse Vokabeltrainer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class VokabelTrainer
{
    public List<Lernkarte> lernkarten;
    
    public VokabelTrainer() {
        lernkarten = new List();
    }
    
    public static void main(String[] args) {
            
    
    }
    
    public void leereTeilListe(String getKat)
    {
        //bestimmte Kategorien löschen
        lernkarten.toFirst();
        int zähler=0;
        while(lernkarten.hasAccess())
        {
            if(getKat==lernkarten.getContent().getKategorie())
            {
                zähler++;
                lernkarten.remove();
                lernkarten.next();
            }
        }
        if(zähler==0) {
            System.out.println("Es wurden 0 Karten" +
            " gelöscht.");
    
        } else
        {
            System.out.println("Es wurden " + zähler + " Karten " +
            "aus " + getKat + " gelöscht.");
        }
    }
    public void leereListe()
    {
        lernkarten.toFirst();
        while(lernkarten.hasAccess()) lernkarten.remove();
    }
    
    public Lernkarte suchen(Lernkarte karte)
    {
        return null;
    }
    
    public void eintragen(String vokabel, String lösung, String kategorie)
    {
        Lernkarte karte= new Lernkarte(vokabel, lösung, kategorie); 
        lernkarten.append(karte);
        System.out.println("Lernkarte zu " + karte.getKategorie() + 
        " hinzugefügt: " + karte.getVokabel());
        
    }
    
    public void anzeigenAlleKarten() {
        System.out.println("Alle Lernkarten:");
        lernkarten.toFirst();
        while(lernkarten.hasAccess()) {
            lernkarten.getContent().anzeigen();
            lernkarten.next();
        }
     }
    public void anzeigenKarten(String kategorie) {
        System.out.println("Lernkarten der Kategorie " + kategorie + ":");
        lernkarten.toFirst();
        while(lernkarten.hasAccess()) {
            if(lernkarten.getContent().getKategorie().equals(kategorie)){
                lernkarten.getContent().anzeigen();
                lernkarten.next();
            }
        }
    }
    
    public void saveFile()
    {
        File file = new File("speicherdatei.txt");
        lernkarten.toFirst();
        
        try
        {
            PrintWriter output = new PrintWriter(file);
            while(lernkarten.hasAccess())
            {
                output.println(lernkarten.getContent().getVokabel());
                output.println(lernkarten.getContent().getLoesung());
                output.println(lernkarten.getContent().getKategorie());
                lernkarten.next();
            }
        } catch(IOException e) {
            System.out.printf("Error: %s\n" , e);
        }
    }
    public void loadFile()
    {
        leereListe();
        Lernkarte tmpLernkarte;
        File file = new File("speicherdatei.txt");    
        try{
            Scanner input = new Scanner(file);
            
            while(input.hasNext()){
                String vokabel = input.nextLine();
                String lösung = input.nextLine();
                String kategorie = input.nextLine();
                
                tmpLernkarte = new Lernkarte(vokabel, lösung, 
                kategorie);
                lernkarten.append(tmpLernkarte);
            }
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.printf("error: %s\n", e);
        }
    }
    public void ladeBeispielvokabeln()
    {
        leereListe();
        Lernkarte tpLernkarte;
        File file2 = new File("BEISPIELVOKABELN.TXT");    
        try{
            Scanner input = new Scanner(file2);
            
            while(input.hasNext()){
                String vokabel = input.nextLine();
                String lösung = input.nextLine();
                String kategorie = input.nextLine();
                
                tpLernkarte = new Lernkarte(vokabel, lösung, 
                kategorie);
                lernkarten.append(tpLernkarte);
            }
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.printf("error: %s\n", e);
        }
    }
    
    public void abfrage(String kategorie){
        List<Lernkarte> abfrageliste = new List<Lernkarte>();
        lernkarten.toFirst();
        abfrageliste.append(new Lernkarte("Platzhalter", "", ""));
        abfrageliste.toFirst();
        int zaehler = 0;
        int richtig=0;
        while(lernkarten.hasAccess()){
            if(lernkarten.getContent().getKategorie().equals(kategorie))
            {
                abfrageliste.append(lernkarten.getContent());
            }
            lernkarten.next();
        }
        abfrageliste.toFirst();
        abfrageliste.remove();
        while(abfrageliste.hasAccess()){
            zaehler++;
            abfrageliste.next();
        }
        abfrageliste.toFirst();
        System.out.println("Übersetze: ");
        Scanner input = new Scanner(System.in);
        for(int i=1; i<=zaehler; i++){
            System.out.println("Vokabel " + i  +"/" + zaehler + ":");
            System.out.println(abfrageliste.getContent().getVokabel());
            String loesung = input.nextLine();
            if(abfrageliste.getContent().getLoesung().equals(loesung)){
                System.out.println("Richtig!");
                richtig++;
            }else{
                System.out.println("Falsch!");
                System.out.println("Richtige Antwort:" + 
                abfrageliste.getContent().getLoesung());
            }
            abfrageliste.next();
        }
        input.close(); 
        System.out.println("Du hast " + richtig + " von " + zaehler + 
        " Vokabeln gewusst.");
        speicherscore(kategorie, richtig, zaehler);
    }
    
    private void speicherscore(String kategorie, int score, int max){
        File file = new File("scoredatei.txt");        
        try
        {
            PrintWriter output = new PrintWriter(file);
            while(lernkarten.hasAccess())
            {
                output.println(kategorie);
                output.println(score);
                output.println(max);
            }
        } catch(IOException e) {
            System.out.printf("Error: %s\n" , e);
        }
    }
}