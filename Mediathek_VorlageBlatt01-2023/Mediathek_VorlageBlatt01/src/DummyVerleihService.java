import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse implementiert das Interface VerleihService. Es handelt sich
 * lediglich um eine Dummy-Implementation, um die GUI zu testen.
 * 
 * @author GUI-Team
 * @version SoSe 2023
 */
class DummyVerleihService extends AbstractObservableService implements
        VerleihService
{
    // Generator fÃ¼r Zufallszahlen und zufÃ¤llige boolsche Werte
    private static final Random RANDOM = new Random();

    private static final CD MEDIUM = new CD("Titel", "Kommentar", "Interpret",
            70);
    private static final Kundennummer KUNDENNUMMER = Kundennummer.get(123456);
    private static final Kunde ENTLEIHER = new Kunde(KUNDENNUMMER, "Vorname",
            "Nachname");
    private static final Verleihkarte VERLEIHKARTE = new Verleihkarte(
            ENTLEIHER, MEDIUM, Datum.heute());

    public DummyVerleihService(KundenstammService kundenstamm,
            MedienbestandService medienbestand,
            List<Verleihkarte> initialBestand)
    {
    }

    /**
     * Beispiel: Gibt immer dasselbe Kundenobjekt als Entleiher zurÃ¼ck, ohne das
     * als Eingabeparameter Ã¼bergebene Medium zu beachten.
     */
    @Override
    public Kunde getEntleiherFuer(Medium medium)
    {
        return ENTLEIHER;
    }

    @Override
    /**
     * Gibt immer die gleiche Liste mit einem Element zurück (Medium oben initialisiert)
     * unabhängig von dem Eingabewert Kunde.
     */
    public List<Medium> getAusgelieheneMedienFuer(Kunde kunde)
    {
        List<Medium> ergebnisListe = new ArrayList<Medium>();
        ergebnisListe.add(MEDIUM);
        return ergebnisListe;
    }
    /**
     * Gibt immer die gleiche Leihkarte zurück (oben initialisiert)
     * unabhängig von dem Eingabewert Medium.
     */
    @Override
    public Verleihkarte getVerleihkarteFuer(Medium medium)
    {
        return VERLEIHKARTE;
    }
    /**
     * Gibt immer die gleiche Liste mit einem Element zurück (Medium oben initialisiert)
     * unabhängig von dem Eingabewert Kunde.
     */
    @Override
    public List<Verleihkarte> getVerleihkarten()
    {
        List<Verleihkarte> ergebnisListe = new ArrayList<Verleihkarte>();
        ergebnisListe.add(VERLEIHKARTE);
        return ergebnisListe;
    }
    /**
     * Gibt immer EINEN Random Boolean zurück
     * unabhängig von dem Eingabewert Medium.
     */
    @Override
    public boolean istVerliehen(Medium medium)
    {
        return RANDOM.nextBoolean();
    }
    /**
     * Macht gar nichts
     */
    @Override
    public void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
    {
    }
    /**
     * Gibt immer EINEN Random Boolean zurück
     * unabhängig von dem Eingabewert Medium.
     */
    @Override
    public boolean sindAlleNichtVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }
    /**
     * Gibt immer EINEN Random Boolean zurück
     * unabhängig von dem Eingabewert Medium.
     */
    @Override
    public boolean sindAlleVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }
    /**
     * Macht gar nichts
     */
    @Override
    public void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
    {
    }
/**
 * Vergleich dassselbe objekt micht sich selbst
 */
    @Override
    public boolean kundeImBestand(Kunde kunde)
    {
        return ENTLEIHER.equals(kunde);
    }
    /**
     * Vergleich dasselbe medium mit sich selbst
     */
    @Override
    public boolean mediumImBestand(Medium medium)
    {
        return MEDIUM.equals(medium);
    }
    /**
     * Vergleich dasselbe medium mit sich selbst
     */
    @Override
    public boolean medienImBestand(List<Medium> medien)
    {
        boolean result = true;
        for (Medium medium : medien)
        {
            if (!mediumImBestand(medium))
            {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Gibt liste mit immer derselben Verleihkarte zurück unabhängig vom Eingabewert Kunde
     */
    @Override
    public List<Verleihkarte> getVerleihkartenFuer(Kunde kunde)
    {
        List<Verleihkarte> result = new ArrayList<Verleihkarte>();
        result.add(VERLEIHKARTE);
        return result;
    }
    /**
     * Immer false
     */
    @Override
    public boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien)
    {
        return false;
    }
}
