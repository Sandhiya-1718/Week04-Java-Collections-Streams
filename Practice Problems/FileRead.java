import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class FileRead {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter file path to read:");
		String file=scanner.nextLine();
		try(BufferedReader reader=new BufferedReader(new FileReader(file)))
		{
			String line;
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.out.println("File not found or cannot be read");
		}
		scanner.close();
	}
}
