import java.util.Stack;

public class SymbolTable {
	private static SymbolTable singleton = new SymbolTable();
	private Stack<Integer> currentOpenBlocks;
	private ArrayList<HashMap<String, String>> dictionnaries;
	private int currentBlockCount;

	private Singleton()
	{
		currentOpenBlocks = new Stack<>();
		dictionnaries = new ArrayList<>();
		currentBlock = 0;
	}

	public void openBlock()
	{
		currentBlock++;
		currentOpenBlocks.push(currentBlock);
		dictionnaries.add(currentBlock, new HashMap<>())
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
				return dictionnaries.get(current).get(name);
			}
		}
		System.err.println("Variable undeclared");
		return null;
	}

	public void add(String name, String type)
	{
		if(dictionnaries.get(currentBlock).containsKey(name))
			System.err.println("Variable already declared");
		else
			dictionnaries.get(currentBlock).put(name, type);
	}

	public static Singleton getInstance()
	{
		return singleton;
	}
}
