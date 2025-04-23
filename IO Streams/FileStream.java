import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class FileStream{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try 
		{
			System.out.print("Enter tha path of the file:");
			File file=new File(scanner.nextLine());
			if(!file.exists())
			{
				System.out.println("Source file not found.");
				return;
			}
			FileInputStream fis=new FileInputStream(file);
			System.out.print("Enter the path of the destination file:");
			File desFile=new File(scanner.nextLine());
			FileOutputStream fos=new FileOutputStream(desFile);
			int data;
			while((data=fis.read())!=-1)
				fos.write(data);
			fis.close();
			fos.close();
			System.out.println("File copied successfully!");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IOException e)
		{
			System.out.println("Error during file read/write."+e.getMessage());
		}
		scanner.close();
	}
}
