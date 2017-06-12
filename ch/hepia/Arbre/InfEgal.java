package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeBooleen;

public class InfEgal extends Relation{
	public InfEgal(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur () {
		return "<=";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }
}
