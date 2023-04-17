
public class Videospiel implements Medium {
private String _titel;
private String _kommentar;
private String _konsole;

	public Videospiel(String titel, String kommentar, String konsole) {
		assert titel != null : "Vorbedingung verletzt: titel != null";
		assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
		assert konsole != null : "Vorbedingung verletzt: konsole != null";
		_titel = titel;
		_kommentar = kommentar;
		_konsole = konsole;
	}

	@Override
	public String getKommentar() {
		return _kommentar;
	}

	@Override
	public String getMedienBezeichnung() {
		return "Videospiel";
	}

	@Override
	public String getTitel() {
		return _titel;
	}
	public String getKonsole() {
		return _konsole;
	}
	
	@Override
    public String getFormatiertenString() {
    return this.getMedienBezeichnung()+ ": " + _titel +" von "+ _konsole;
    }


}
