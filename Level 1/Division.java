import java.util.Scanner;
public class Division {
	public static int performDivision(int numerator,int denominator)
	{
		if(denominator==0)
			throw new ArithmeticException("Cannot divide by zero.");
		return numerator/denominator;
	}
	public static int calculate(int numerator,int denominator)
	{
		try
		{
			return performDivision(numerator,denominator);
		}
		catch(ArithmeticException e)
		{
			throw new ArithmeticException("Error in calculate():"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter numerator:");
		int num=scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter denominator:");
		int den=scanner.nextInt();
		scanner.nextLine();
		try
		{
			int result=calculate(num,den);
			System.out.println("Result:"+result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("An error occured during division:\n"+e.getMessage());
		}
		scanner.close();
	}
}

