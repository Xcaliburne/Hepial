package ch.hepia.Arbre;

import java.util.ArrayList;

public class Condition extends Instruction{
	
	private Expression condition;
	private Bloc alors;
	private Bloc sinon;
	/**
	 * @param lig
	 * @param condition
	 * @param alors
	 * @param sinon
	 */
	public Condition(Expression condition, Bloc alors, Bloc sinon, int lig) {
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
	public Bloc getAlors() {
		return alors;
	}
	public void setAlors(Bloc alors) {
		this.alors = alors;
	}
	public Bloc getSinon() {
		return sinon;
	}
	public void setSinon(Bloc sinon) {
		this.sinon = sinon;
	}
}
