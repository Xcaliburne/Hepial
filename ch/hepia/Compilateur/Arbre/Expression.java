package ch.hepia.Compilateur.Arbre;
import ch.hepia.Compilateur.Types.*;

public abstract class Expression implements ArbreAbstrait {
   	private int lig;

   	public Expression(int lig) {
   		this.lig = lig;
   	}
   	
   	public abstract Type getType();
}
