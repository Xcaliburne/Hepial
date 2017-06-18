package ch.hepia.Compilateur;

import ch.hepia.Compilateur.Arbre.*;

public interface Visiteur {
	
	    Object visiter(Bloc b);
	    Object visiter(Linstr list);

	    Object visiter(Addition a);
	    Object visiter(Soustraction s);
	    Object visiter(Nombre n);
	    Object visiter(Booleen b);
	    Object visiter(Produit p);
	    Object visiter(Division d);

	    Object visiter(Egal e);
	    Object visiter(Inferieur e);
	    Object visiter(InfEgal e);
	    Object visiter(Superieur e);
	    Object visiter(SupEgal e);
	    Object visiter(Different e);
	    //expression
	    Object visiter(Affectation a);
	    Object visiter(Idf i);
	    Object visiter(Condition c);
	    Object visiter(Ecrire e);
	    Object visiter(Pour p);
	    Object visiter(Tantque t);
	    Object visiter(Ou ou);
	    Object visiter(Et et);
	    Object visiter(Lire l);
	    Object visiter(Tilde t);
	    Object visiter(Non n);
}
