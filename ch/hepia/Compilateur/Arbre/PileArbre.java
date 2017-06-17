package ch.hepia.Compilateur.Arbre;

import java.util.Stack;

public class PileArbre extends Stack<ArbreAbstrait>{

	public PileArbre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized ArbreAbstrait pop() {
		// TODO Auto-generated method stub
//		System.out.println("poped "+this.peek().getClass());
		return super.pop();
	}

	@Override
	public ArbreAbstrait push(ArbreAbstrait item) {
		// TODO Auto-generated method stub
//		System.out.println("pushed "+item.getClass());
		return super.push(item);
	}
	
	
}
