package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.*;

public class Ou extends Binaire{
	public Ou(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur(){
		return "ou";
	}
	
	public Type getType(){
		return TypeBooleen.getInstance();
	}
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
