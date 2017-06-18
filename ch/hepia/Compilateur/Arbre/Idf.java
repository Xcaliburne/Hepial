package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.Type;

public class Idf extends Expression {
	protected String nom;
	private Type type;
	private int jasminID = -1;

	public Idf(String nom, int lig) {
        super(lig);
		jasminID = -1;
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

	public int getJasminID(){
		return jasminID;
	}

	public void setJasminID(int id) {
		jasminID = id;
	}

	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
