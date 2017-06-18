package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.*;

public class Booleen extends Expression {
	private Boolean valeur;
	private Type type = TypeBooleen.getInstance();
	
	public Booleen (Boolean val, int lig) {
		super(lig);
		this.valeur = val;
	}

	public Boolean getValeur() {
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

