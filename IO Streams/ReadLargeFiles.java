import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ReadLargeFiles {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the path of the large text file:");
		String filePath=scanner.nextLine();
		try (BufferedReader br=new BufferedReader(new FileReader(filePath)))
		{
			String line;
			System.out.println("\n---Lines Contaning 'error'---");
			while((line=br.readLine())!=null)
			{
				if(line.toLowerCase().contains("error"))
					System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.out.println("File read error:"+e);
		}
		scanner.close();
	}
}
