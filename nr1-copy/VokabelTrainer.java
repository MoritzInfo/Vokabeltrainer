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
    
    public void leereListe()
    {
        
    }
    
    public Lernkarte suchen(Lernkarte karte)
    {
        return null;
    }
    
    public void eintragen(String vok, String lös, String kat)
    {
        Lernkarte karte= new Lernkarte(vok, lös, kat); 
        lernkarten.append(karte);
        System.out.println("Lernkarte hinzugefügt: " + karte.getVokabel());
        
    }
    
    public void anzeigenAlleKarten() {
        System.out.println("Alle Lernkarten:");
        //for (Lernkarte karte : lernkarten) {
        //    karte.anzeigen();
        //}
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
        
        
        
        Scanner input = new Scanner(file);
        
        
    }
}
