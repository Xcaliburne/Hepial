package Arbre;

public class Egal extends Relation{
	public Egal (Expression g, Expression d, int lig) {
		super(g, d, lig);
	}

	public String operateur () {
		return "==";
	}

    public Type getType() {
        return TypeBooleen.getInstance();
    }
}
