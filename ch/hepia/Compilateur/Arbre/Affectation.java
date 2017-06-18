package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;
import ch.hepia.Compilateur.Types.*;

public class Affectation extends Instruction{
	
	private Expression source;
	private Idf destination;
	private Type type;
	

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
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String toString() {
    	return destination + " = " + source;
    }
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
