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
    
    public void leereListe(String getKat)
    {
        //ka ob funktioniert
        lernkarten.toFirst();
        int zähler=0;
        if(getKat==null)
        {
            while(lernkarten.hasAccess()) lernkarten.remove();
        } else
        {
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
    
    public void saveFile()
    {
        File file = new File("Vokabelliste.txt");
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
        
        
        
        //Scanner input = new Scanner(file);
        
        
    }
}
