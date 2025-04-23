import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class DataStreams {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try
		{
			System.out.print("Enter number of students:");
			int n=Integer.parseInt(scanner.nextLine());
			System.out.print("Enter the file path to save student data:");
			String file=scanner.nextLine();
			DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter details for student "+(i+1));
				System.out.print("Roll Number:");
				int roll=Integer.parseInt(scanner.nextLine());
				System.out.print("Name:");
				String name=scanner.nextLine();
				System.out.print("GPA:");
				double gpa=Double.parseDouble(scanner.nextLine());
				dos.writeInt(roll);
				dos.writeUTF(name);
				dos.writeDouble(gpa);
			}
			dos.close();
			System.out.println("Student data saved successfully.");
			DataInputStream dis=new DataInputStream(new FileInputStream(file));
			System.out.println("---Retrieved Student Details---");
			for(int i=0;i<n;i++)
			{
				int roll=dis.readInt();
				String name=dis.readUTF();
				double gpa=dis.readDouble();
				System.out.println("Roll:"+roll+" | Name:"+name+" | GPA:"+gpa);
			}
			dis.close();
		}
		catch(IOException e)
		{
			System.out.println("File Error");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number format");
		}
		scanner.close();
	}
}
