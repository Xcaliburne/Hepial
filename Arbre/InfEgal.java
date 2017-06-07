package Arbre;

public class InfEgal extends Relation{
	public InfEgal(Expression g, Expression d, int lig) {
		super(g, d, lig);
		// TODO Auto-generated constructor stub
	}
	
	public String operateur () {
		return "<=";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }
}
