import java.util.ArrayList;

public class ErrorHandler {
	private static ErrorHandler singleton = null;
	private ArrayList<String> errors;

	private ErrorHandler()
	{}

	public static ErrorHandler getInstance()
	{
		if (singleton == null)
		{
			singleton = new ErrorHandler();
			singleton.errors = new ArrayList<>();
		}

		return singleton;
	}

	public void addError(String error)
	{
		errors.add(error);
	}

	public void printErrors()
	{
		for(String error : errors)
		{
			System.out.println(error);
		}
	}
}
