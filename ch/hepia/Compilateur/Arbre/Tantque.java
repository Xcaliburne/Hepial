package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;

public class Tantque extends Instruction{
	
	private Expression condition;
	private Linstr Boucle;

	public Tantque(Expression condition, Linstr boucle, int lig) {
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

	public Linstr getBoucle() {
		return Boucle;
	}

	public void setBoucle(Linstr boucle) {
		Boucle = boucle;
	}
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
	
}
