import java.util.Vector;
import java.io.FileReader;

public class Compilateur {
	public static void main (String[] arg)
	{
		try
		{
			FileReader myFile = new FileReader(arg[0]);
			Lexer myLex = new Lexer(myFile);
			parser myP = new parser(myLex);
			try
			{
				myP.parse();
			}
			catch(Exception e)
			{
				System.out.println("parse error: " + e);
			}
		}
		catch(Exception e)
		{
			System.out.println("invalid file");
		}
	}
}
