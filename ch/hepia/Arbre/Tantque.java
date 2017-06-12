package ch.hepia.Arbre;

public class Tantque extends Instruction{
	
	private Expression condition;
	private Bloc Boucle;

	public Tantque(Expression condition, Bloc boucle, int lig) {
		super(lig);
		this.condition = condition;
		this.Boucle = boucle;
	}

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public Bloc getBoucle() {
		return Boucle;
	}

	public void setBoucle(Bloc boucle) {
		Boucle = boucle;
	}
	
	
	
}
