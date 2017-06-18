package ch.hepia.Compilateur;

import ch.hepia.Compilateur.Arbre.Addition;
import ch.hepia.Compilateur.Arbre.Affectation;
import ch.hepia.Compilateur.Arbre.Arithmetique;
import ch.hepia.Compilateur.Arbre.Bloc;
import ch.hepia.Compilateur.Arbre.Booleen;
import ch.hepia.Compilateur.Arbre.Condition;
import ch.hepia.Compilateur.Arbre.Different;
import ch.hepia.Compilateur.Arbre.Division;
import ch.hepia.Compilateur.Arbre.Ecrire;
import ch.hepia.Compilateur.Arbre.Egal;
import ch.hepia.Compilateur.Arbre.Et;
import ch.hepia.Compilateur.Arbre.Idf;
import ch.hepia.Compilateur.Arbre.InfEgal;
import ch.hepia.Compilateur.Arbre.Inferieur;
import ch.hepia.Compilateur.Arbre.Linstr;
import ch.hepia.Compilateur.Arbre.Lire;
import ch.hepia.Compilateur.Arbre.Nombre;
import ch.hepia.Compilateur.Arbre.Ou;
import ch.hepia.Compilateur.Arbre.Pour;
import ch.hepia.Compilateur.Arbre.Produit;
import ch.hepia.Compilateur.Arbre.Relation;
import ch.hepia.Compilateur.Arbre.Soustraction;
import ch.hepia.Compilateur.Arbre.SupEgal;
import ch.hepia.Compilateur.Arbre.Superieur;
import ch.hepia.Compilateur.Arbre.Tantque;

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
}
