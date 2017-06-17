package ch.hepia.Compilateur.Arbre;

public class Affectation extends Instruction{
	
	private Expression source;
	private Idf destination;
	

	/**
	 * @param lig
	 * @param source
	 * @param destination
	 */
	public Affectation(Expression source, Idf destination, int lig) {
		super(lig);
		this.source = source;
		this.destination = destination;
	}

	public Expression getSource() {
		return source;
	}

	public void setSource(Expression source) {
		this.source = source;
	}

	public Idf getDestination() {
		return destination;
	}

	public void setDestination(Idf destination) {
		this.destination = destination;
	}
	
	public String toString() {
    	return destination + " = " + source;
    }
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
