import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
public class ReadUserInput {
	public static void main(String[] args) {
		BufferedReader reader=null;
		FileWriter writer=null;
		try
		{
			reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter your name:");
			String name=reader.readLine();
			System.out.print("Enter your age:");
			String age=reader.readLine();
			System.out.print("Enter your favourite language:");
			String language=reader.readLine();
			System.out.print("Enter the full path with file name:");
			String filePath=reader.readLine();
			writer=new FileWriter(filePath);
			writer.write("Name :"+name+"\n");
			writer.write("Age :"+age+"\n");
			writer.write("Favorite Language :"+language+"\n");
			System.out.println("Information added successfully to the mentioned path");
		}
		catch(IOException e)
		{
			System.out.println("ERROR..!");
		}
		finally
		{
			try 
			{
				if(reader!=null)
					reader.close();
				if(writer!=null)
					writer.close();
			}
			catch(IOException e)
			{
				System.out.println("Error closing resources.");
			}
		}
	}
}
