package Arbre;

public class TypeTableau {
	
	private Type type;

    public TypeTableau() {
		// TODO Auto-generated constructor stub
	}


    public boolean estConforme(Type t) {
        return t instanceof TypeEntier;
    }

    public String toString() {
        return "ENTIER";
    }
}
