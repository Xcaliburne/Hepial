package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.Type;
import ch.hepia.Compilateur.Types.TypeBooleen;

public class Inferieur extends Relation{

	public Inferieur(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}

	public String operateur () {
		return "<";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
