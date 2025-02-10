
/**
 * Beschreiben Sie hier die Klasse vokabeltrainer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.ArrayList;

public class VokabelTrainer {
    private ArrayList<Lernkarte> lernkarten;

    // Konstruktor
    public VokabelTrainer() {
        lernkarten = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Lernkarte
    public void hinzufuegenLernkarte(Lernkarte karte) {
        lernkarten.add(karte);
        System.out.println("Lernkarte hinzugefügt: " + karte.getVokabel());
    }

    // Methode zum Anzeigen aller Lernkarten
    public void anzeigenAlleKarten() {
        System.out.println("Alle Lernkarten:");
        for (Lernkarte karte : lernkarten) {
            karte.anzeigen();
        }
    }
}