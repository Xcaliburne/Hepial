package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.Type;
import ch.hepia.Compilateur.Types.TypeBooleen;

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
    
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
