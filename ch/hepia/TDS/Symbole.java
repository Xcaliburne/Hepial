package ch.hepia.TDS;

import ch.hepia.Types.Type;

public class Symbole {

    private int line;

    private Type type;

    public Symbole(Type type, int line){
      this.type = type;
      this.line = line;
    }

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}    
}
