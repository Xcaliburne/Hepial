package ch.hepia.Compilateur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class JasminGenerateur implements Visiteur {
	private BufferedWriter jasminStream = null;

	public JasminGenerateur(String filename)
	{
		jasminStream = new BufferedWriter(new FileWriter(new File(filename)));
		jasminStream.write(".class public Main");
		jasminStream.writeNewLine();
		jasminStream.write(".super java/lang/Object");
		jasminStream.writeNewLine();
		jasminStream.write("aload_0");
		jasminStream.writeNewLine();
		jasminStream.write("invokespecial java/lang/Object/<init>()V");
		jasminStream.writeNewLine();
		jasminStream.write("return");
		jasminStream.writeNewLine();
		jasminStream.write(".end method");
		jasminStream.writeNewLine();
		jasminStream.write(".super java/lang/Object");
		jasminStream.writeNewLine();
		jasminStream.write(".method public static main([Ljava/lang/String;)V");
		jasminStream.writeNewLine();
	}

	public void generate(PileArbre stack)
	{
		while(!stack.isEmpty())
			visiter(stack.pop());

		jasminStream.write("return");
		jasminStream.writeNewLine();
		jasminStream.write(".end method");
		jasminStream.writeNewLine();
		jasminStream.close();
		jasminStream.close();
	}

	Object visiter(Bloc b);
	Object visiter(Linstr list);

	Object visiter(Addition a);
	Object visiter(Soustraction s);
	Object visiter(Nombre n);
	Object visiter(Produit p);
	Object visiter(Division d);

	Object visiter(Egal e);
	Object visiter(Inferieur e);
	Object visiter(InfEgal e);
	Object visiter(Superieur e);
	Object visiter(SupEgal e);
	Object visiter(Different e);

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
