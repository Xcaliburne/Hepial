package ch.hepia.Arbre;

import java.util.ArrayList;

public class Pour extends Instruction{
	
	private Idf idf;
	private Expression BorneInf;
	private Expression BorneSup;
	private Bloc instr;
	/**
	 * @param lig
	 * @param idf
	 * @param borneInf
	 * @param borneSup
	 * @param instr
	 */
	public Pour(Idf idf, Expression borneInf, Expression borneSup, Bloc instr, int lig) {
		super(lig);
		this.idf = idf;
		BorneInf = borneInf;
		BorneSup = borneSup;
		this.instr = instr;
	}
	/**
	 * @return the idf
	 */
	public Idf getIdf() {
		return idf;
	}
	/**
	 * @param idf the idf to set
	 */
	public void setIdf(Idf idf) {
		this.idf = idf;
	}
	/**
	 * @return the borneInf
	 */
	public Expression getBorneInf() {
		return BorneInf;
	}
	/**
	 * @param borneInf the borneInf to set
	 */
	public void setBorneInf(Expression borneInf) {
		BorneInf = borneInf;
	}
	/**
	 * @return the borneSup
	 */
	public Expression getBorneSup() {
		return BorneSup;
	}
	/**
	 * @param borneSup the borneSup to set
	 */
	public void setBorneSup(Expression borneSup) {
		BorneSup = borneSup;
	}
	/**
	 * @return the instr
	 */
	public Bloc getInstr() {
		return instr;
	}
	/**
	 * @param instr the instr to set
	 */
	public void setInstr(Bloc instr) {
		this.instr = instr;
	}
	
	
	

}
