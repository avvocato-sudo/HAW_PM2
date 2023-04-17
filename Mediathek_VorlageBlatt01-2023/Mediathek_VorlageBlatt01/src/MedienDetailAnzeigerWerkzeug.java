import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import java.lang.StringBuilder;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2023
 */
class MedienDetailAnzeigerWerkzeug
{
    private MedienDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public MedienDetailAnzeigerWerkzeug()
    {
        _ui = new MedienDetailAnzeigerUI();
    }

    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
    
    
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: (medien != null)";
        TextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
        StringBuilder ausgabe =  new StringBuilder(); 
        for(Medium medium : medien) {
        	if(medium instanceof CD) {
        		CD newCD = new CD(medium.getTitel(), medium.getKommentar(), ((CD) medium).getInterpret(), ((CD) medium).getSpiellaenge());
        		ausgabe.append(newCD.getFormatiertenString()+ "\n");
        	}else if(medium instanceof DVD) {
        		DVD newDVD = new DVD(medium.getTitel(), medium.getKommentar(), ((DVD) medium).getRegisseur(), ((DVD) medium).getLaufzeit());;
        		ausgabe.append(newDVD.getFormatiertenString() +  "\n");
        	}else if(medium instanceof Videospiel) {
        		Videospiel newSpiel = new Videospiel(medium.getTitel(), medium.getKommentar(), ((Videospiel) medium).getKonsole());
        		ausgabe.append(newSpiel.getFormatiertenString() + "\n");
        	}
        }
        selectedMedienTextArea.setText(ausgabe.toString());
    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public Pane getUIPane()
    {
        return _ui.getUIPane();
    }
}
