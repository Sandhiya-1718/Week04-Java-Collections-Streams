import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileProcessor{
	public void processFile(List<String> filePaths)
	{
		for(String path:filePaths)
		{
			System.out.println("Processing file:"+path);
			try(BufferedReader reader=new BufferedReader(new FileReader(path)))
			{
				String line;
				while((line=reader.readLine())!=null)
					System.out.println(line);
			}
			catch(IOException e)
			{
				System.out.println("Error reading file:"+path);
				System.out.println("Exception:"+e.getMessage());
			}
			System.out.println("Finished processing:"+path);
			System.out.println("-----------------------------");
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<String> files=new ArrayList<>();
		System.out.print("Enter the number of files to process:");
		int count=Integer.parseInt(scanner.nextLine());
		for(int i=1;i<=count;i++)
		{
			System.out.print("Enter path for file "+i+":");
			String path=scanner.nextLine();
			files.add(path);
		}
		FileProcessor processor=new FileProcessor();
		processor.processFile(files);
		scanner.close();
	}
}
