package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;

public class Ecrire extends Instruction{
	private Expression texte;
	public Ecrire(Expression t, int lig) {
        super(lig);
        this.texte = t;
    }

    public Expression getTexte() {
        return this.texte;
    }

    public void setTexte(Expression t) {
        this.texte = t;
    }
    
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
