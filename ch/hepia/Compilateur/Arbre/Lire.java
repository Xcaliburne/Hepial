package ch.hepia.Compilateur.Arbre;

public class Lire extends Instruction{
	private Idf id;

    public Lire(Idf id, int lig) {
        super(lig);
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
}
