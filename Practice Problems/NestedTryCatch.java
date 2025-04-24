import java.util.Scanner;
public class NestedTryCatch {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try
		{
			System.out.print("Enter the number of elements in the array:");
			int size=scanner.nextInt();
			int numbers[]=new int[size];
			for(int i=0;i<size;i++)
			{
				System.out.print("Enter "+(i+1)+" value:");
				numbers[i]=scanner.nextInt();
				scanner.nextLine();
			}
			System.out.print("Enter index to access:");
			int index=scanner.nextInt();
			try
			{
				int value=numbers[index];
				System.out.print("Enter a number to divide by:");
				int divisor=scanner.nextInt();
				int result=value/divisor;
				System.out.println("Result:"+result);
			}
			catch(ArithmeticException e)
			{
				System.out.println("Cannot divide by zero!");
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid array index.");
		}
		catch(Exception e)
		{
			System.out.println("Unexpected error:"+e.getMessage());
		}
		finally
		{
			scanner.close();
			System.out.println("Operation completed.");
		}
	}
}
