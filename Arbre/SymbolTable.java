package Arbre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
	private static SymbolTable singleton = null;
	private Stack<Integer> currentOpenBlocks;
	private ArrayList<HashMap<String, Symbole>> dictionnaries;
	private int currentBlockCount;

	private SymbolTable()
	{

	}

	public void openBlock()
	{
		currentOpenBlocks.push(currentBlockCount);
		dictionnaries.add(currentBlockCount, new HashMap<String, Symbole>());
		currentBlockCount++;
	}

	public void closeBlock()
	{
		currentOpenBlocks.pop();
	}

	public String identify(String name)
	{
		Stack<Integer> tmp = new Stack<>();
		while(!currentOpenBlocks.isEmpty())
		{
			Integer current = currentOpenBlocks.pop();
			tmp.push(current);
			if(dictionnaries.get(current).containsKey(name))
			{
				while(!tmp.isEmpty())
					currentOpenBlocks.push(tmp.pop());
				return dictionnaries.get(current).get(name).getType().toString();
			}
		}
		System.err.println("Variable undeclared");
		return null;
	}

	public void add(String name, Symbole s)
	{
		if(dictionnaries.get(currentBlockCount-1).containsKey(name))
			System.err.println("Variable already declared: " + name);
		else
			dictionnaries.get(currentBlockCount-1).put(name, s);
	}

	public static SymbolTable getInstance()
	{
		if (singleton == null){
			singleton = new SymbolTable();
			singleton.currentOpenBlocks = new Stack<>();
			singleton.dictionnaries = new ArrayList<>();
			singleton.currentBlockCount = 0;
			return singleton;
		}
		return singleton;
	}

	public Integer getCurrentBlock(){
		return this.currentOpenBlocks.peek();
	}
}
