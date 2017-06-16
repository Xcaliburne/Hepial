package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.Type;

public class Idf extends Expression {
	protected String nom;
	private Type type;
	
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
    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
