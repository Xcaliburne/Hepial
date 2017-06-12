package ch.hepia.Arbre;

import ch.hepia.Types.*;

public class Ou extends Arithmetique{
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
		
}
