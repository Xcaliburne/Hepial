package ch.hepia.Compilateur.Arbre;

public class Ecrire extends Instruction{
	private Expression texte;
	private String constante;
	private boolean isString = false;

	public Ecrire(Expression t, int lig) {
        super(lig);
        this.texte = t;
		isString = false;
    }

	public Ecrire(String str, int lig) {
        super(lig);
        this.constante = str;
		isString = true;
    }

    public Expression getTexte() {
        return this.texte;
    }

    public void setTexte(Expression t) {
        this.texte = t;
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
