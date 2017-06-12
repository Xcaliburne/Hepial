package ch.hepia.Arbre;

import ch.hepia.Types.Type;

public class Idf extends Expression {
	protected String nom;
	
	public Idf(String nom, int lig) {
        super(lig);
		this.nom = nom;
	}

    public String getName() {
        return this.nom;
    }

    public String toString() {
        return this.nom;
    }
}
