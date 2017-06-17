package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.Type;
import ch.hepia.Compilateur.Types.TypeEntier;

public class Soustraction extends Arithmetique{
	public Soustraction(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur(){
		return "-";
	}
	
	public Type getType(){
		return TypeEntier.getInstance();
	}
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
