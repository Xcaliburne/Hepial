package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeBooleen;

public class Egal extends Relation{
	public Egal (int lig) {
		super(null, null, lig);
	}

	public String operateur () {
		return "==";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }
}
