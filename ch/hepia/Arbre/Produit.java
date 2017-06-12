package ch.hepia.Arbre;

import ch.hepia.Types.*;

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
}
