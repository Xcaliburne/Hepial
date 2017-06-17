package ch.hepia.Compilateur.Arbre;

public class Condition extends Instruction{
	
	private Expression condition;
	private Linstr alors;
	private Linstr sinon;
	/**
	 * @param lig
	 * @param condition
	 * @param alors
	 * @param sinon
	 */
	public Condition(Expression condition, Linstr alors, Linstr sinon, int lig) {
		super(lig);
		this.condition = condition;
		this.alors = alors;
		this.sinon = sinon;
	}
	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	public Linstr getAlors() {
		return alors;
	}
	public void setAlors(Linstr alors) {
		this.alors = alors;
	}
	public Linstr getSinon() {
		return sinon;
	}
	public void setSinon(Linstr sinon) {
		this.sinon = sinon;
	}
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
