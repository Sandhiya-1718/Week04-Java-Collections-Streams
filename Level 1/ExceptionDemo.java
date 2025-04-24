import java.io.IOException;
import java.util.Scanner;
public class ExceptionDemo {
	public static void processData(String input) throws IOException
	{
		if(input.equalsIgnoreCase("error"))
			throw new IOException("IO error simulated for input:"+input);
		int number=Integer.parseInt(input);
		System.out.println("You entered valid number:"+number);
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter some data:");
		String input=scanner.nextLine();
		try
		{
			processData(input);
		}
		catch(IOException e)
		{
			System.out.println("Checked Exception caught:"+e.getMessage());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Unchecked Exception caught. Input must be a number."+e.getMessage());
		}
		scanner.close();
	}
}
