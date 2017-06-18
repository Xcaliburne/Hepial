package ch.hepia.Compilateur.Arbre;

import ch.hepia.Compilateur.Visiteur;

public interface ArbreAbstrait {
	public Object accepter(Visiteur v);
}
