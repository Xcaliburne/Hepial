package ch.hepia.Arbre;

import ch.hepia.Types.Type;
import ch.hepia.Types.TypeBooleen;
import ch.hepia.Types.TypeEntier;

public class Et extends Arithmetique{

	public Et(int lig) {
		super(null, null, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur(){
		return "et";
	}
	
	public Type getType(){
		return TypeBooleen.getInstance();
	}
		
}
