package ch.hepia.Compilateur.Arbre;

import java.util.ArrayList;
import java.util.List;

public class Linstr extends Instruction{

	private ArrayList<Instruction> inst_list;

	/**
	 * @param lig
	 */
	public Linstr(int lig) {
		super(lig);
		// TODO Auto-generated constructor stub
		this.inst_list = new ArrayList<Instruction>();
	}

	/**
	 * @param lig
	 * @param inst_list
	 */
	public Linstr(int lig, ArrayList<Instruction> inst_list) {
		super(lig);
		setInst_list(inst_list);
	}



	public ArrayList<Instruction> getInst_list() {
		return inst_list;
	}

	public void setInst_list(ArrayList<Instruction> inst_list) {
		this.inst_list = inst_list;
	}
	
	public void add(Instruction inst){
		this.inst_list.add(inst);
	}
	
	public Object accepter(Visiteur v) {
        return v.visiter(this);
    }
}
