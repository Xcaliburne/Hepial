package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.Type;
import ch.hepia.Compilateur.Types.TypeEntier;

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
    
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
    
    
}
