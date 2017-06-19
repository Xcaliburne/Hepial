package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;

public class Lire extends Instruction{
	private Idf id;

    public Lire(Idf id, int lig) {
        super(lig);
        this.id = id;
    }

    public Idf getIdf() {
        return this.id;
    }

    public void setIdf(Idf id) {
        this.id = id;
    }
    
    public Object accepter(Visiteur v) {
        return v.visiter(this);
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "lire "+id;
	}
}
