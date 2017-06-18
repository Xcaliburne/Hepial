package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.*;

public class Non extends Unaire {
	public Non(int lig) {
		super(null, lig);
	}

	public String operateur(){
		return "non";
	}

	public Type getType(){
		return TypeBooleen.getInstance();
	}
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
