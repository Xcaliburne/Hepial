package ch.hepia.Arbre;

import ch.hepia.Types.Type;

public class Idf extends Expression {
	protected String nom;
	protected Type type;

	public Idf(String nom, int lig) {
        super(lig);
		this.nom = nom;
	}

    public Type getType() {
        return this.type;
    }

    public void setType(Type t) {
        this.type = t;
    }

    public String getName() {
        return this.nom;
    }

    public String toString() {
        return this.nom;
    }
}
