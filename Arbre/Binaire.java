package Arbre;

public abstract class Binaire extends Expression {
		protected Expression operandeGauche; // operande gauche
		protected Expression operandeDroit; // operande droit
		
		// Construire a partir des deux operandes
		public Binaire (Expression g, Expression d, int lig) {
			super(lig);
			operandeGauche = g;
			operandeDroit = d;
		} // binaire
		
		public Expression getOperandeGauche() {
			return operandeGauche;
		}

		public void setOperandeGauche(Expression operandeGauche) {
			this.operandeGauche = operandeGauche;
		}

		public Expression getOperandeDroit() {
			return operandeDroit;
		}

		public void setOperandeDroit(Expression operandeDroit) {
			this.operandeDroit = operandeDroit;
		}

		public String toString() {
			return "(" + operandeGauche+operateur()+operandeDroit+")";
		} // toString
		
		public abstract String operateur();
}
