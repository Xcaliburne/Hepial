package ch.hepia.Arbre;

public class Nombre extends Expression {
	private int valeur;
	
	public Nombre (Integer val, int lig) {
		super(lig);
		this.valeur = val.intValue();
	}

	public int valeur() {
		return valeur;
	}
	
	public String toString() {
		return ""+valeur;
	}
}

