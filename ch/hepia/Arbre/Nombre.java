package ch.hepia.Arbre;

public class Nombre extends Expression {
	private int valeur;
	// Creer a partir de la valeur du nombre
	public Nombre (Integer val, int lig) {
		super(lig);
		this.valeur = val.intValue();
	} // Nombre
	// valeur de l’expression
	public int valeur() {
		return valeur;
	} // valeur
	public String toString() {
		return ""+valeur;
	} // toString
} // Nombre

