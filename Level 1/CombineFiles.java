import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class CombineFiles {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the path of the first file:");
		String file1=scanner.nextLine();
		System.out.print("Enter the path of the second file:");
		String file2=scanner.nextLine();
		System.out.print("Enter the path of the output file:");
		String output=scanner.nextLine();
		try
		(
			BufferedReader reader1=new BufferedReader(new FileReader(file1));
			BufferedReader reader2=new BufferedReader(new FileReader(file2));
			BufferedWriter writer=new BufferedWriter(new FileWriter(output));
		)
		{
			String line;
			while((line=reader1.readLine())!=null)
			{
				writer.write(line);
				writer.newLine();
			}
			while((line=reader2.readLine())!=null)
			{
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Data merged.");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error finding the file."+e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("IO Error:"+e.getMessage());
		}
	}
}
