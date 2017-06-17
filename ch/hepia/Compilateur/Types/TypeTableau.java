package ch.hepia.Compilateur.Types;

public class TypeTableau extends Type{
	
	private Type type;
	private int[] BorneInf;
	private int[] BorneSup;



    public TypeTableau(Type type, int[] borneInf, int[] borneSup) {
		super();
		this.type = type;
		BorneInf = borneInf;
		BorneSup = borneSup;
	}

	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public int[] getBorneInf() {
		return BorneInf;
	}



	public void setBorneInf(int[] borneInf) {
		BorneInf = borneInf;
	}



	public int[] getBorneSup() {
		return BorneSup;
	}



	public void setBorneSup(int[] borneSup) {
		BorneSup = borneSup;
	}

	public boolean estConforme(Type t) {
		if (!(t instanceof TypeTableau)){
			return false;
		}
        
		if (!(this.BorneInf.length == ((TypeTableau) t).BorneInf.length) && !(type.estConforme(((TypeTableau) t).type)) ){
			return false;
		}
		for (int i = 0; i < BorneInf.length; i++) {
			int nb = this.BorneSup[i] - this.BorneInf[i];
			int nbt = ((TypeTableau) t).BorneSup[i] - ((TypeTableau) t).BorneInf[i];
			if (nb != nbt){
				return false;
			}
		}
		return true;
    }

    public String toString() {
        return "ENTIER";
    }
}
