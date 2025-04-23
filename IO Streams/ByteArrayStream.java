import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class ByteArrayStream {
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		try
		{
			System.out.print("Enter path of source image:");
			String file=scanner.nextLine();
			FileInputStream fis=new FileInputStream(file);
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte buffer[]=new byte[4096];
			int bytesRead;
			while((bytesRead=fis.read(buffer))!=-1)
				baos.write(buffer,0,bytesRead);
			fis.close();
			byte imageBytes[]=baos.toByteArray();
			System.out.print("Enter the path to save the new image:");
			String desPath=scanner.nextLine();
			ByteArrayInputStream bias=new ByteArrayInputStream(imageBytes);
			FileOutputStream fos=new FileOutputStream(desPath);
			while((bytesRead=bias.read(buffer))!=-1)
				fos.write(buffer,0,bytesRead);
			fos.close();
			bias.close();
			System.out.println("Image copied successfully as byte array.");
		}
		catch(IOException e)
		{
			System.out.println("Error:"+e.getMessage());
		}
		scanner.close();
	}
}
