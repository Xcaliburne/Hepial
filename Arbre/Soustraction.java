package Arbre;

public class Soustraction extends Arithmetique{
	public Soustraction(Expression g, Expression d, int lig) {
		super(g, d, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur(){
		return "-";
	}
	
	public Type getType(){
		return TypeEntier.getInstance();
	}
}
