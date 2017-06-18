package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Types.*;

public abstract class Unaire extends Expression {
		protected Expression operande;

		public Unaire (Expression o, int lig) {
			super(lig);
			operande = o;
		}

		public Expression getOperande() {
			return operande;
		}

		public void setOperande(Expression operande) {
			this.operande = operande;
		}

		public String toString() {
			return "("+ operateur()+operande+")";
		} // toString

		public abstract String operateur();

}
