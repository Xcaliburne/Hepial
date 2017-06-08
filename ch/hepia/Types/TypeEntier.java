package ch.hepia.Types;

import java.util.*;

public class TypeEntier extends Type {

    // Singleton.
    private static TypeEntier instance;

    private TypeEntier(){
      
    }

    public static TypeEntier getInstance() {
      if (instance == null)
  		{
        instance = new TypeEntier();
  		}
  		return instance;
    }

    public boolean estConforme(Type t) {
        return t instanceof TypeEntier;
    }

    public String toString() {
        return "ENTIER";
    }
}
