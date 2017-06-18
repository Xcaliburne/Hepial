package ch.hepia.Compilateur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ch.hepia.Compilateur.Arbre.*;

import java.io.File;

public class JasminGenerateur implements Visiteur {
	private BufferedWriter jasminStream = null;
	private int variableCounter = 0;
	private int conditionCounter = 0;
	private int nestedCounter = 0;

	public JasminGenerateur(String filename)
	{
		try {
			jasminStream = new BufferedWriter(new FileWriter(new File(filename)));
			jasminStream.write(".class public Main");
			jasminStream.newLine();
			jasminStream.write(".super java/lang/Object");
			jasminStream.newLine();
			jasminStream.write(".method public <init>()V");
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
			jasminStream.write(".limit stack 5");
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
			jasminStream.write(".limit stack 5");
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
			jasminStream.write(".limit stack 10");
			jasminStream.newLine();
			jasminStream.write("new java/util/Scanner");
			jasminStream.newLine();
			jasminStream.write("dup");
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
			jasminStream.write(".limit locals 100");
			jasminStream.newLine();
			jasminStream.write(".limit stack 100");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
	}

	public void generate(PileArbre stack)
	{
		while(!stack.isEmpty())
			stack.pop().accepter(this);
		try{
			jasminStream.write("return");
			jasminStream.newLine();
			jasminStream.write(".end method");
			jasminStream.newLine();
			jasminStream.close();
			jasminStream.close();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
	}

	public Object visiter(Bloc b)
	{
		for(Instruction i : b.getInst_list())
			i.accepter(this);
		return null;
	}

	public Object visiter(Linstr list)
	{
		for(Instruction i : list.getInst_list())
			i.accepter(this);
		return null;
	}

	public Object visiter(Addition a)
	{
		a.getOperandeGauche().accepter(this);
		a.getOperandeDroite().accepter(this);
		try {
			jasminStream.write("iadd");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Soustraction s)
	{
		s.getOperandeGauche().accepter(this);
		s.getOperandeDroite().accepter(this);

		try {
			jasminStream.write("isub");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Nombre n)
	{
		try{
			jasminStream.write("ldc " + n.getValeur());
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Produit p)
	{
		p.getOperandeGauche().accepter(this);
		p.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("imul");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Tilde t)
	{
		t.getOperande().accepter(this);
		try{
			jasminStream.write("ineg");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Division d)
	{
		d.getOperandeGauche().accepter(this);
		d.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("idiv");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Egal e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifeq IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Inferieur e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("iflt IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(InfEgal e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifle IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Superieur e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifgt IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Non n)
	{
		n.getOperande().accepter(this);
		try{
			jasminStream.newLine();
			jasminStream.write("ifeq IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(SupEgal e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifge IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Different e)
	{
		e.getOperandeGauche().accepter(this);
		e.getOperandeDroite().accepter(this);
		try{
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifne IN" + conditionCounter);
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Affectation a)
	{
		int id = a.getDestination().getJasminID();
		a.getSource().accepter(this);

		try{
			jasminStream.write("istore " + id);
			jasminStream.newLine();
		} catch (IOException error) {
			System.err.println(error.getMessage());
		}

		return null;
	}

	public Object visiter(Idf i)
	{
		if(i.getJasminID() == -1)
			return null;
		try{
			jasminStream.write("iload " + i.getJasminID());
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Condition c)
	{
		c.getCondition().accepter(this);
		try{
			jasminStream.newLine();
			if(c.getCondition() instanceof Idf)
			{
				jasminStream.write("ifne IN" + conditionCounter);
				jasminStream.newLine();
			}
			jasminStream.write("NOTIN" + conditionCounter + ":");
			jasminStream.newLine();
			c.getSinon().accepter(this);
			jasminStream.write("goto NEXT" + conditionCounter);
			jasminStream.newLine();
			jasminStream.write("IN" + conditionCounter + ":");
			jasminStream.newLine();
			c.getAlors().accepter(this);
			jasminStream.write("NEXT" + conditionCounter + ":");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		conditionCounter++;

		return null;
	}

	public Object visiter(Ecrire e)
	{
		if(e.isString())
		{
			try{
				jasminStream.write("ldc \"" + e.getString() + "\"");
				jasminStream.newLine();
				jasminStream.write("invokestatic Main.print(Ljava/lang/String;)V");
				jasminStream.newLine();
			} catch (IOException error) {
				// TODO Auto-generated catch block
				System.err.println(error.getMessage());
			}
		}
		else
		{
			try{
				e.getExpr().accepter(this);
				jasminStream.write("invokestatic Main.print(I)V");
				jasminStream.newLine();
			} catch (IOException error) {
				// TODO Auto-generated catch block
				System.err.println(error.getMessage());
			}
		}
		return null;
	}

	public Object visiter(Pour p)
	{
		int id = p.getIdf().getJasminID();
		if(id == -1)
			return null;

		try{
			jasminStream.write("ldc " + p.getBorneInf());
			jasminStream.newLine();
			jasminStream.write("istore " + id);
			jasminStream.newLine();
			jasminStream.write("IN" + conditionCounter + ":");
			jasminStream.newLine();
			p.getInstr().accepter(this);
			jasminStream.write("iinc " + id + " 1");
			jasminStream.newLine();
			jasminStream.write("iload " + id);
			jasminStream.newLine();
			jasminStream.write("ldc " + p.getBorneSup());
			jasminStream.newLine();
			jasminStream.write("isub");
			jasminStream.newLine();
			jasminStream.write("ifle IN" + conditionCounter);
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		conditionCounter++;
		return null;
	}

	public Object visiter(Tantque t)
	{
		t.getCondition().accepter(this);
		try{
			jasminStream.newLine();
			jasminStream.write("goto NEXT" + conditionCounter);
			jasminStream.newLine();
			jasminStream.write("IN" + conditionCounter + ":");
			jasminStream.newLine();
			t.getBoucle().accepter(this);
			t.getCondition().accepter(this);
			jasminStream.newLine();
			jasminStream.write("NEXT" + conditionCounter + ":");
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		conditionCounter++;
		return null;
	}

	public Object visiter(Ou ou)
	{
		try{
			ou.getOperandeGauche().accepter(this);
			jasminStream.newLine();
			ou.getOperandeDroite().accepter(this);
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Et et)
	{
		nestedCounter++;
		et.getOperandeGauche().accepter(this);
		try{
			jasminStream.newLine();
			jasminStream.write("n" + nestedCounter);
			jasminStream.newLine();
			jasminStream.write("goto NOTIN" + conditionCounter);
			jasminStream.newLine();
			jasminStream.write("IN" + conditionCounter + "n" + nestedCounter + ":");
			jasminStream.newLine();
			et.getOperandeDroite().accepter(this);
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	public Object visiter(Lire l)
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
		try{
			jasminStream.write("invokestatic Main.read()I");
			jasminStream.newLine();
			jasminStream.write("istore " + id);
			jasminStream.newLine();
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}

	@Override
	public Object visiter(Booleen b) {
		try{
			if(b.getValeur())
			{
				jasminStream.write("ldc 1");
				jasminStream.newLine();
			}
			else
			{
				jasminStream.write("ldc 0");
				jasminStream.newLine();
			}
		} catch (IOException error) {
			// TODO Auto-generated catch block
			System.err.println(error.getMessage());
		}
		return null;
	}
	
	public void close() throws IOException{
		this.jasminStream.close();
	}
}
