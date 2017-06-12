package ch.hepia.Arbre;

public abstract class Binaire extends Expression {
		protected Expression operandeGauche; // operande gauche
		protected Expression operandeDroite; // operande droit
		
		// Construire a partir des deux operandes
		public Binaire (Expression g, Expression d, int lig) {
			super(lig);
			operandeGauche = g;
			operandeDroite = d;
		} // binaire
		
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
