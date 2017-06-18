package ch.hepia.Compilateur.Arbre;
import ch.hepia.Compilateur.Types.*;

public abstract class Expression implements ArbreAbstrait {
   	private int ligne;

   	public Expression(int lig) {
   		this.ligne = ligne;
   	}
   	
   	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}



	public abstract Type getType();
}
