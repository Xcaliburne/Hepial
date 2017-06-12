package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeEntier;

public class Addition extends Arithmetique{

	public Addition(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur(){
		return "+";
	}
	
	public Type getType(){
		return TypeEntier.getInstance();
	}
}
