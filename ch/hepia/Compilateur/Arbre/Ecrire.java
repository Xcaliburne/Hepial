package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;

public class Ecrire extends Instruction{
	private Expression expr;
	private String constante;
	private boolean isString = false;

	public Ecrire(Expression t, int lig) {
        super(lig);
        this.expr = t;
		isString = false;
    }

	public Ecrire(String str, int lig) {
        super(lig);
        this.constante = str;
		isString = true;
    }

    public Expression getExpr() {
        return this.expr;
    }

    public void setExpr(Expression t) {
        this.expr = t;
    }

	public String getString() {
        return this.constante;
    }

	public void setString(String str) {
        this.constante = str;
    }

	public boolean isString()
	{
		return isString;
	}

    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
