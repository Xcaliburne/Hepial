package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeBooleen;

public class Inferieur extends Relation{

	public Inferieur(Expression g, Expression d, int lig) {
		super(g, d, lig);
		// TODO Auto-generated constructor stub
	}

	public String operateur () {
		return "<";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }

}
