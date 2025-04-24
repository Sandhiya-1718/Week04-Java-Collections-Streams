import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ReadFileWithTryResources {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the filename:");
		String file=scanner.nextLine();
		try(BufferedReader reader=new BufferedReader(new FileReader(file)))
		{
			String firstLine=reader.readLine();
			if(firstLine!=null)
				System.out.println("First line of "+file+":"+firstLine);
			else
				System.out.println("The file is empty.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading file:"+e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	}
}
