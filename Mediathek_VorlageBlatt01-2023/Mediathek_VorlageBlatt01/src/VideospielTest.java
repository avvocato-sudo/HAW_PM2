import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "DVD";
    private static final String KONSOLE = "Konsole";
    private Videospiel _spiel1;
    private Videospiel _spiel2;

    public VideospielTest()
    {
    	_spiel1 = getMedium();
    	_spiel2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String spielBezeichnung = BEZEICHNUNG;
        assertEquals(spielBezeichnung, _spiel1.getMedienBezeichnung());
    }

    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _spiel1.getTitel());
        assertEquals(KOMMENTAR, _spiel1.getKommentar());
        assertEquals(KONSOLE, _spiel1.getKonsole());
    }

    @Test
    /*
     * Von ein und dem selben Spiel kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare der gleichen DVD sind gleich",
                _spiel1.equals(_spiel2));
        assertTrue("Mehrere Exemplare der gleichen DVD sind ungleich",
                _spiel1.equals(_spiel1));
    }

    protected Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, KONSOLE);
    }

}