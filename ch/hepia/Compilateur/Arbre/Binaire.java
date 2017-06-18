package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.*;

public abstract class Binaire extends Expression {
		protected Expression operandeGauche; 
		protected Expression operandeDroite;
		
		public Binaire (Expression g, Expression d, int lig) {
			super(lig);
			operandeGauche = g;
			operandeDroite = d;
		}
		
		public Expression getOperandeGauche() {
			return operandeGauche;
		}

		public void setOperandeGauche(Expression operandeGauche) {
			this.operandeGauche = operandeGauche;
		}

		public Expression getOperandeDroite() {
			return operandeDroite;
		}

		public void setOperandeDroite(Expression operandeDroit) {
			this.operandeDroite = operandeDroit;
		}

		public String toString() {
			return "(" + operandeGauche+operateur()+operandeDroite+")";
		} // toString
		
		public abstract String operateur();

}
