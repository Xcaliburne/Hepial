package ch.hepia.Compilateur;

import java.util.ArrayList;

public class GestionnaireErreur extends ArrayList<String>{

	private static GestionnaireErreur instance = null;
	private GestionnaireErreur(){
		
	}
	
	public static GestionnaireErreur getInstance(){
		if (instance == null){
			instance = new GestionnaireErreur();
		}
		return instance;
	}
	
	public void printErrors(){
		for (String error : this) {
			System.err.println(error);
		}
	}
}
