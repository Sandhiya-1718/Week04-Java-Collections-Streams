import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FilterStreams {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try
		{
			System.out.print("Enter source file path:");
			String sourcePath=scanner.nextLine();
			System.out.print("Enter destincation file path:");
			String desPath=scanner.nextLine();
			BufferedReader reader=new BufferedReader(new FileReader(sourcePath));
			BufferedWriter writer=new BufferedWriter(new FileWriter(desPath));
			String line;
			while((line=reader.readLine())!=null)
			{
				writer.write(line.toLowerCase());
				writer.newLine();
			}
			reader.close();
			writer.close();
			System.out.println("File converted to lowercase and saved successfully.");
		}
		catch(IOException e)
		{
			System.out.println("Error.!");
		}
		scanner.close();
	}
}
