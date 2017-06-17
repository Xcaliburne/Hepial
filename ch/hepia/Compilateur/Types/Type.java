package ch.hepia.Compilateur.Types;

import java.util.*;

public abstract class Type {

    public abstract boolean estConforme(Type t);

    public abstract String toString();
}
