package ch.hepia.Compilateur;

public class Erreur {
	private int line;
	private String errorMessage;
	
	
	public Erreur(int line, String errorMessage) {
		super();
		this.line = line;
		this.errorMessage = errorMessage;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ligne "+line+": "+errorMessage;
	}
	
}
