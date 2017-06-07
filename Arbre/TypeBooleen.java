package Arbre;

import java.util.*;

public class TypeBooleen extends Type {

    // Singleton.
    private static TypeBooleen instance;

    private TypeBooleen(){

    }

    public static TypeBooleen getInstance() {
      if (instance == null)
      {
        instance = new TypeBooleen();
      }
      return instance;
    }

    public boolean estConforme(Type t) {
        return t instanceof TypeBooleen;
    }

    public String toString() {
        return "BOOLEEN";
    }
}
