package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.*;

public class Produit extends Arithmetique {

	public Produit (int lig) {
		super(null, null, lig);
	}

	public String operateur () {
		return "*";
	}

    public Type getType() {
        return TypeEntier.getInstance();
    }
    
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
