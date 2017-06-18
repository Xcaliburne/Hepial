SRCFLEX = hepial.flex
SRCCUP = hepial.cup
OBJ = sym.class parser.class Lexer.class test.class

all : Lexer.java sym.java parser.java class run

Lexer.java: $(SRCFLEX)
	jflex $(SRCFLEX)

sym.java parser.java: Lexer.java $(SRCCUP)
	java -jar java-cup-11b.jar $(SRCCUP)

class: sym.java parser.java Lexer.java
	javac -classpath java-cup-11b.jar:. sym.java
	javac -classpath java-cup-11b.jar:. parser.java
	javac -classpath java-cup-11b.jar:. Lexer.java
	javac -classpath java-cup-11b.jar:. Compilateur.java

run:
	java -classpath java-cup-11b.jar:. Compilateur exemple/hepial1.hepial
	java -jar jasmin-2.4/jasmin.jar output.j
	java Main

runError:
	java -classpath java-cup-11b.jar:. Compilateur exempleErreur

clean:
	rm -f *.class *~ Lexer.java sym.java parser.java parse_prog
