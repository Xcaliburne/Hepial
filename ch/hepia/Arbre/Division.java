package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeEntier;

public class Division extends Arithmetique{

	public Division (int lig) {
		super(null, null, lig);
	}

	public String operateur () {
		return "/";
	}

    public Type getType() {
        return TypeEntier.getInstance();
    }
}
