package ch.hepia.Compilateur.Arbre;

public abstract class Instruction implements ArbreAbstrait{
	private int lig;

   	public Instruction(int lig) {
   		this.lig = lig;
   	}
   	
   	public int getLigne(){
   		return this.lig;
   	}
}
