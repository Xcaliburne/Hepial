package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.Type;
import ch.hepia.Compilateur.Types.TypeBooleen;

public class Superieur extends Relation{
	public Superieur (int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}

	public String operateur () {
		return ">";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }

    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
