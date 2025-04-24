import java.util.Scanner;
public class ArrayAccessExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int array[]=null;
		try
		{
			System.out.print("Enter size of array:");
			int size=scanner.nextInt();
			if(size<=0)
			{
				System.out.println("Invalid array sie. Exiting.");
				return;
			}
			array=new int[size];
			for(int i=0;i<size;i++)
			{
				System.out.println("Enter "+(i+1)+" elements.");
				array[i]=scanner.nextInt();
			}
			System.out.print("Enter index to retrieve:");
			int index=scanner.nextInt();
			int value=array[index];
			System.out.println("Value at index "+index+":"+value);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid index!");
		}
		catch(NullPointerException e)
		{
			System.out.println("Array is not initialized!");
		}
		catch(Exception e)
		{
			System.out.println("Unexpected error:"+e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	}

}
