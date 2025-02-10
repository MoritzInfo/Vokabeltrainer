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
    public ArrayList<Lernkarte> lernkarten;
    
    public VokabelTrainer() {
        lernkarten = new ArrayList<>();
    }
    
    public static void main(String[] args) {
            
    
    }
    
    public Lernkarte suchen(Lernkarte karte)
    {
        return null;
    }
    
    public void eintragen(String vok, String lös, String kat)
    {
        Lernkarte karte= new Lernkarte(vok, lös, kat); 
        lernkarten.add(karte);
        System.out.println("Lernkarte hinzugefügt: " + karte.getVokabel());
        
    }
    
    public void anzeigenAlleKarten() {
        System.out.println("Alle Lernkarten:");
        for (Lernkarte karte : lernkarten) {
            karte.anzeigen();
        }
     }
    
    public void saveFile()
    {
    
    }
    
    public void loadFile(){}
}
