package ch.hepia.Compilateur;

import java.util.ArrayList;

public class GestionnaireErreur extends ArrayList<Erreur>{

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
		for (Erreur error : this) {
			System.err.println(error);
		}
	}
	
	public void add(int ligne, String message){
		this.add(new Erreur(ligne, message));
	}
}
