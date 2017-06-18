package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.*;

public class Nombre extends Expression {
	private int valeur;
	private Type type = TypeEntier.getInstance();
	
	public Nombre (int val, int lig) {
		super(lig);
		this.valeur = val;
	}

	public int valeur() {
		return valeur;
	}
	
	public String toString() {
		return ""+valeur;
	}
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}

