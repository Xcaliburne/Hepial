package ch.hepia.Compilateur;

import java.util.ArrayList;
import ch.hepia.Compilateur.Arbre.*;
import ch.hepia.Compilateur.TDS.*;
import ch.hepia.Compilateur.Types.*;

public class AnalyseurSemantique implements Visiteur{
	private ArrayList<String> noms = null;
	private static AnalyseurSemantique instance = null;
	private static String ncf = "Source et destination non conformes";
	private static String eb = "Expression booleenne attendue";
	private static String nd = "Identificateur non declare";
	private static String ti = "Typage incorrect";

	
	private AnalyseurSemantique() {

	}

	public static AnalyseurSemantique getInstance() {
		if (instance == null)
		{
			instance = new AnalyseurSemantique();
			instance.noms = new ArrayList<>();
		}
		return instance;
	}

	public void visiter(PileArbre stack){
		PileArbre tmp = new PileArbre();

		while(!stack.isEmpty()){
			ArbreAbstrait arbre = (ArbreAbstrait)stack.pop();
			arbre.accepter(this);
			tmp.push(arbre);
		}
		while(!tmp.isEmpty()){
			stack.push(tmp.pop());
		}
	}

	@Override
	public Object visiter(Bloc b) {
		for (Instruction instr : b.getInst_list()) {
			instr.accepter(this);
		}
		return null;
	}

	@Override
	public Object visiter(Linstr list) {
		for (Instruction instr : list.getInst_list()) {
			instr.accepter(this);
		}
		return null;
	}

	@Override
	public Object visiter(Addition a) {
		validerBinaire(a);
		return null;
	}

	@Override
	public Object visiter(Soustraction s) {
		validerBinaire(s);
		return null;
	}

	@Override
	public Object visiter(Nombre n) {
		return null;
	}

	@Override
	public Object visiter(Produit p) {
		validerBinaire(p);
		return null;
	}

	@Override
	public Object visiter(Division d) {
		validerBinaire(d);
		return null;
	}

	@Override
	public Object visiter(Egal e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(Inferieur e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(InfEgal e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(Superieur e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(SupEgal e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(Different e) {
		validerBinaire(e);
		return null;
	}

	@Override
	public Object visiter(Affectation a) {
		a.getDestination().accepter(this);
		Type typeDest = a.getDestination().getType();
		Object v = a.getSource().accepter(Evaluateur.getInstance());
		if (v != null){
			a.setSource(new Nombre( (Integer)v, a.getSource().getLigne()) );
		}
		a.getSource().accepter(this);
		Type typeSource = a.getSource().getType();
		if (! (typeSource.estConforme(typeDest)) ){
			GestionnaireErreur.getInstance().add(a.getLigne(), ncf);
		}else{
			a.setType(typeDest);
		}
		return null;

	}

	@Override
	public Object visiter(Idf i) {
		Symbole s = SymbolTable.getInstance().identify(i.getName());
		if (s != null){
			i.setType(s.getType());
			if(!noms.contains(i.getName()))
				noms.add(i.getName());
			i.setJasminID(noms.indexOf(i.getName()));
		}else{
			GestionnaireErreur.getInstance().add(i.getLigne(), nd);
		}
		return null;
	}

	@Override
	public Object visiter(Condition c) {
		Object v = c.getCondition().accepter(Evaluateur.getInstance());
		if (v != null)
			c.setCondition((Booleen)v);
		else {
			c.getCondition().accepter(this);
			if (c.getCondition().getType() != TypeBooleen.getInstance()){
				GestionnaireErreur.getInstance().add(c.getLigne(), eb);
			}
		}
		c.getAlors().accepter(this);
		c.getSinon().accepter(this);
		return null;
	}

	@Override
	public Object visiter(Ecrire e) {
		if (!e.isString()){
			e.getExpr().accepter(this);
		}
		return null;
	}

	@Override
	public Object visiter(Pour p) {
		p.getIdf().accepter(this);
		p.getBorneInf().accepter(this);
		p.getBorneSup().accepter(this);
		p.getInstr().accepter(this);
		return null;
	}

	@Override
	public Object visiter(Tantque t) {
		t.getCondition().accepter(this);
		t.getBoucle().accepter(this);
		return null;
	}

	@Override
	public Object visiter(Ou ou) {
		validerBinaire(ou);
		return null;
	}

	@Override
	public Object visiter(Et et) {
		validerBinaire(et);
		return null;
	}

	@Override
	public Object visiter(Lire l) {
		// TODO Auto-generated method stub
		l.getIdf().accepter(this);
		return null;
	}

	@Override
	public Object visiter(Booleen b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visiter(Tilde t) {
		validerUnaire(t);
		return null;
	}

	@Override
	public Object visiter(Non n) {
		validerUnaire(n);
		return null;
	}
	
	private void validerBinaire(Binaire b){
		b.getOperandeGauche().accepter(this);
		b.getOperandeDroite().accepter(this);
		if (!b.getOperandeDroite().getType().estConforme(b.getOperandeGauche().getType())){
			GestionnaireErreur.getInstance().add(b.getLigne(), ncf);
		}
	}
	
	private void validerUnaire(Unaire u){
		u.getOperande().accepter(this);
		if (!u.getOperande().getType().estConforme(u.getType())){
			GestionnaireErreur.getInstance().add(u.getLigne(), ncf);
		}
	}
}
