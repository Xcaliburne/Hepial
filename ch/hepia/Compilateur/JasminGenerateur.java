package ch.hepia.Compilateur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class JasminGenerateur implements Visiteur {
	private BufferedWriter jasminStream = null;
	private int variableCounter = 0;
	private int conditionCounter = 0;
	private int nestedCounter = 0;

	public JasminGenerateur(String filename)
	{
		jasminStream = new BufferedWriter(new FileWriter(new File(filename)));
		jasminStream.write(".class public Main");
		jasminStream.newLine();
		jasminStream.write(".super java/lang/Object");
		jasminStream.newLine();
		jasminStream.write(".method public ()V");
		jasminStream.newLine();
		jasminStream.write("aload_0");
		jasminStream.newLine();
		jasminStream.write("invokespecial java/lang/Object/<init>()V");
		jasminStream.newLine();
		jasminStream.write("return");
		jasminStream.newLine();
		jasminStream.write(".end method");
		jasminStream.newLine();
		jasminStream.write(".method public static print(I)V");
		jasminStream.newLine();
		jasminStream.write(".limit locals 3");
		jasminStream.newLine();
		jasminStream.write(".limit stack 5 ");
		jasminStream.newLine();
		jasminStream.write("iload 0 ");
		jasminStream.newLine();
		jasminStream.write("getstatic java/lang/System/out Ljava/io/PrintStream;");
		jasminStream.newLine();
		jasminStream.write("swap");
		jasminStream.newLine();
		jasminStream.write("invokevirtual java/io/PrintStream/println(I)V");
		jasminStream.newLine();
		jasminStream.write("return");
		jasminStream.newLine();
		jasminStream.write(".end method");
		jasminStream.newLine();
		jasminStream.write(".method public static print(Ljava/lang/String;)V");
		jasminStream.newLine();
		jasminStream.write(".limit locals 3");
		jasminStream.newLine();
		jasminStream.write(".limit stack 5 ");
		jasminStream.newLine();
		jasminStream.write("aload 0 ");
		jasminStream.newLine();
		jasminStream.write("getstatic java/lang/System/out Ljava/io/PrintStream;");
		jasminStream.newLine();
		jasminStream.write("swap");
		jasminStream.newLine();
		jasminStream.write("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
		jasminStream.newLine();
		jasminStream.write("return");
		jasminStream.newLine();
		jasminStream.write(".end method");
		jasminStream.newLine();
		jasminStream.write(".method public static read()I");
		jasminStream.newLine();
		jasminStream.write(".limit locals 10");
		jasminStream.newLine();
		jasminStream.write(".limit stack 10 ");
		jasminStream.newLine();
		jasminStream.write("new java/util/Scanner");
		jasminStream.newLine();
		jasminStream.write("getstatic java/lang/System/in Ljava/io/InputStream;");
		jasminStream.newLine();
		jasminStream.write("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
		jasminStream.newLine();
		jasminStream.write("invokevirtual java/io/Scanner/nextInt()I");
		jasminStream.newLine();
		jasminStream.write("ireturn");
		jasminStream.newLine();
		jasminStream.write(".end method");
		jasminStream.newLine();
		jasminStream.write(".method public static main([Ljava/lang/String;)V");
		jasminStream.newLine();
	}

	public void generate(PileArbre stack)
	{
		while(!stack.isEmpty())
			visiter(stack.pop());

		jasminStream.write("return");
		jasminStream.newLine();
		jasminStream.write(".end method");
		jasminStream.newLine();
		jasminStream.close();
		jasminStream.close();
	}

	Object visiter(Bloc b)
	{
		for(Instruction i : b.getInst_list())
			visiter(i);
		return null;
	}

	Object visiter(Linstr list)
	{
		for(Instruction i : list.getInst_list())
			visiter(i);
		return null;
	}

	Object visiter(Addition a)
	{
		visiter(a.getOperandeGauche());
		visiter(a.getOperandeDroite());
		jasminStream.write("iadd");
		jasminStream.newLine();
		return null;
	}

	Object visiter(Soustraction s)
	{
		visiter(s.getOperandeGauche());
		visiter(s.getOperandeDroite());

		jasminStream.write("isub");
		jasminStream.newLine();
		return null;
	}

	Object visiter(Nombre n)
	{
		jasminStream.write("ldc" + n.valeur());
		jasminStream.newLine();
		return null;
	}

	Object visiter(Produit p)
	{
		visiter(p.getOperandeGauche());
		visiter(p.getOperandeDroite());

		jasminStream.write("imul");
		jasminStream.newLine();
		return null;
	}

	Object visiter(Division d)
	{
		visiter(d.getOperandeGauche());
		visiter(d.getOperandeDroite());

		jasminStream.write("idiv");
		jasminStream.newLine();
		return null;
	}

	Object visiter(Egal e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifeq IN" + conditionCounter);
		return null;
	}

	Object visiter(Inferieur e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("iflt IN" + conditionCounter);
		return null;
	}

	Object visiter(InfEgal e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifle IN" + conditionCounter);
		return null;
	}

	Object visiter(Superieur e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifgt IN" + conditionCounter);
		return null;
	}

	Object visiter(SupEgal e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifge IN" + conditionCounter);
		return null;
	}

	Object visiter(Different e)
	{
		visiter(e.getOperandeGauche());
		visiter(e.getOperandeDroite());
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifne IN" + conditionCounter);
		return null;
	}

	Object visiter(Affectation a)
	{
		Idf var = a.getDestination();
		int id = 0;
		if(var.getJasminID() == -1)
		{
			var.setJasminID(variableCounter);
			id = variableCounter;
			variableCounter++;
		}
		else
			id = var.getJasminID();

		Expression value = a.getSource();
		if(value instanceof Nombre)
		{
			Nombre n = (Nombre) value;
			jasminStream.write("ldc " + n.valeur());
			jasminStream.newLine();
			jasminStream.write("istore " + id);
			jasminStream.newLine();
		}
		else
		{
			visiter(value);
			jasminStream.write("istore " + id);
			jasminStream.newLine();
		}

		return null;
	}

	Object visiter(Idf i)
	{
		if(i.getJasminID == -1)
			return null;

		jasminStream.write("iload " + i.getJasminID);
		jasminStream.newLine();
		return null;
	}

	Object visiter(Condition c)
	{
		visiter(c.getCondition());
		jasminStream.write("NOTIN" + conditionCounter + ":");
		jasminStream.newLine();
		visiter(c.getSinon());
		jasminStream.write("goto NEXT" + conditionCounter);
		jasminStream.newLine();
		jasminStream.write("IN" + conditionCounter + ":");
		jasminStream.newLine();
		visiter(c.getAlors());
		jasminStream.write("NEXT" + conditionCounter + ":");
		jasminStream.newLine();

		conditionCounter++;

		return null;
	}

	Object visiter(Ecrire e)
	{
		if(e.isString)
		{
			jasminStream.write("ldc \"" + e.getString) + "\"");
			jasminStream.newLine();
			jasminStream.write("invokestatic Main.print(Ljava/lang/String;)V");
			jasminStream.newLine();
		}
		else
		{
			visiter(e.getTexte);
			jasminStream.write("invokestatic Main.print(I)V");
			jasminStream.newLine();
		}
		return null;
	}

	Object visiter(Pour p)
	{
		Idf var = p.getIdf();
		int id = 0;
		if(var.getJasminID() == -1)
		{
			var.setJasminID(variableCounter);
			id = variableCounter;
			variableCounter++;
		}
		else
			id = var.getJasminID();

		jasminStream.write("ldc " + p.getBorneInf());
		jasminStream.newLine();
		jasminStream.write("istore " + id);
		jasminStream.newLine();
		jasminStream.write("IN" + conditionCounter + ":");
		jasminStream.newLine();
		visiter(p.getInstr());
		jasminStream.write("iinc " + id + " 1");
		jasminStream.newLine();
		jasminStream.write("iload " + id);
		jasminStream.newLine();
		jasminStream.write("ldc " + p.getBorneSup);
		jasminStream.newLine();
		jasminStream.write("isub");
		jasminStream.newLine();
		jasminStream.write("ifle IN" + conditionCounter);
		jasminStream.newLine();

		conditionCounter++;
		return null;
	}

	Object visiter(Tantque t)
	{
		visiter(t.getCondition());
		jasminStream.write("goto NEXT" + conditionCounter);
		jasminStream.newLine();
		jasminStream.write("IN" + conditionCounter + ":");
		jasminStream.newLine();
		visiter(t.getBoucle());
		visiter(t.getCondition());
		jasminStream.write("NEXT" + conditionCounter + ":");
		jasminStream.newLine();

		conditionCounter++;
		return null;
	}

	Object visiter(Ou ou)
	{
		visiter(ou.getOperandeGauche());
		jasminStream.newLine();
		visiter(ou.getOperandeDroite());
		jasminStream.newLine();
		return null;
	}

	Object visiter(Et et)
	{
		nestedCounter++;
		visiter(et.getOperandeGauche());
		jasminStream.write("n" + nestedCounter);
		jasminStream.newLine();
		jasminStream.write("goto NOTIN" + conditionCounter);
		jasminStream.newLine();
		jasminStream.write("IN" + conditionCounter + "n" + nestedCounter + ":");
		jasminStream.newLine();
		visiter(et.getOperandeDroite());
		jasminStream.newLine();

		return null;
	}

	Object visiter(Lire l)
	{
		Idf var = l.getIdf();
		int id = 0;
		if(var.getJasminID() == -1)
		{
			var.setJasminID(variableCounter);
			id = variableCounter;
			variableCounter++;
		}
		else
			id = var.getJasminID();

		jasminStream.write("invokestatic Main.read()I");
		jasminStream.newLine();
		jasminStream.write("istore " + id);
		jasminStream.newLine();
		return null;
	}
}
