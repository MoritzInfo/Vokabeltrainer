
/**
 * Beschreiben Sie hier die Klasse lernkarte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */


    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public class Lernkarte {
    private String vokabel;
    private String loesung;
    private String kategorie;

    // Konstruktor
    public Lernkarte(String vokabel, String loesung, String kategorie) {
        this.vokabel = vokabel;
        this.loesung = loesung;
        this.kategorie = kategorie;
    }

    // Getter-Methoden
    public String getVokabel() {
        return vokabel;
    }

    public String getLoesung() {
        return loesung;
    }

    public String getKategorie() {
        return kategorie;
    }

    // Methode zur Anzeige der Lernkarte
    public void anzeigen() {
        System.out.println("Vokabel: " + vokabel + " | Lösung: " + loesung + " | Kategorie: " + kategorie);
    }
}

