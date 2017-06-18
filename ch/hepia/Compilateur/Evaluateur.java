package ch.hepia.Compilateur;

import java.io.BufferedWriter;

import ch.hepia.Compilateur.Arbre.*;

public class Evaluateur implements Visiteur{
	private static Evaluateur instance = null;

	private Evaluateur() {

	}

	public static Evaluateur getInstance() {
		if (instance == null)
		{
			instance = new Evaluateur();
		}
		return instance;
	}

	@Override
	public Object visiter(Bloc b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Linstr list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Addition a) {
		Object valG = a.getOperandeGauche().accepter(this);
		if (valG == null) {
			return null;
		}
		Object valD = a.getOperandeDroite().accepter(this);
		if (valD == null){
			return null;
		}
		int g = ((Integer)valG).intValue();
		int d = ((Integer)valD).intValue();
		return new Integer(g+d);
	}

	@Override
	public Object visiter(Soustraction s) {
		Object valG = s.getOperandeGauche().accepter(this);
		if (valG == null) {
			return null;
		}
		Object valD = s.getOperandeDroite().accepter(this);
		if (valD == null){
			return null;
		}
		int g = ((Integer)valG).intValue();
		int d = ((Integer)valD).intValue();
		return new Integer(g-d);
	}

	@Override
	public Object visiter(Nombre n) {
		return new Integer(n.getValeur());
	}

	@Override
	public Object visiter(Produit p) {
		Object valG = p.getOperandeGauche().accepter(this);
		if (valG == null) {
			return null;
		}
		Object valD = p.getOperandeDroite().accepter(this);
		if (valD == null){
			return null;
		}
		int g = ((Integer)valG).intValue();
		int d = ((Integer)valD).intValue();
		return new Integer(g+d);
	}

	@Override
	public Object visiter(Division div) {
		Object valG = div.getOperandeGauche().accepter(this);
		if (valG == null) {
			return null;
		}
		Object valD = div.getOperandeDroite().accepter(this);
		if (valD == null){
			return null;
		}
		int g = ((Integer)valG).intValue();
		int d = ((Integer)valD).intValue();
		return new Integer(g/d);
	}

	@Override
	public Object visiter(Egal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Inferieur e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(InfEgal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Superieur e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(SupEgal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Different e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Affectation a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Idf i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Condition c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Ecrire e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Pour p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Tantque t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Ou ou) {
		Object valG = ou.getOperandeGauche().accepter(this);
		Object valD = ou.getOperandeDroite().accepter(this);
		if (valG != null) {
			int valintG = ((Integer)valG).intValue();
			return (valintG == 1)?valG:null;
		}
		if (valD != null) {
			int valintD = ((Integer)valD).intValue();
			return (valintD == 1)?valD:null;
		}
		return null;
	}

	@Override
	public Object visiter(Et et) {
		Object valG = et.getOperandeGauche().accepter(this);
		if (valG != null) {
			int valintG = ((Integer)valG).intValue();
			return (valintG == 0)?valG:null;
		}
		Object valD = et.getOperandeDroite().accepter(this);
		if (valD != null) {
			int valintD = ((Integer)valD).intValue();
			return (valintD == 0)?valD:null;
		}
		return null;
	}

	@Override
	public Object visiter(Lire l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Booleen b) {
		// TODO Auto-generated method stub
		return b.getValeur();
	}
}
