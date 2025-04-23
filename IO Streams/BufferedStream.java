import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class BufferedStream {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try
		{
			System.out.print("Enter the path of the source file");
			File file=new File(scanner.nextLine());
			if(!file.exists())
			{
				System.out.println("Source file not found.");
				return;
			}
			FileInputStream fis=new FileInputStream(file);
			BufferedInputStream bis=new BufferedInputStream(fis);
			System.out.print("Enter the path of the destination file:");
			File desFile=new File(scanner.nextLine());
			FileOutputStream fos=new FileOutputStream(desFile);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			byte buffer[]=new byte[4096];
			int byteRead;
			long startTime=System.nanoTime();
			while((byteRead=bis.read(buffer))!=-1)
				bos.write(buffer,0,byteRead);
			bos.flush();
			long endTime=System.nanoTime();
			bis.close();
			bos.close();
			fis.close();
			fos.close();
			long elapsedTime=(endTime-startTime)/1_000_000;
			System.out.println("File copied successfully.!");
			System.out.println("Time taken:"+elapsedTime+"ms");
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
