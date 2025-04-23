import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
	private int id;
	private String name;
	private String department;
	private double salary;
	
	public Employee(int id,String name,String department,double salary)
	{
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	
	@Override
	public String toString()
	{
		return "Employee{ID="+id+", Name="+name+", Dept="+department+", Salary="+salary+"}";
	}
}

public class SaveAndRetrieve {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		List<Employee> empList=new ArrayList<>();
		System.out.print("Enter number of employees:");
		int n=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter details for Employee "+(i+1));
			System.out.print("ID:");
			int id=Integer.parseInt(scanner.nextLine());
			System.out.print("Name:");
			String name=scanner.nextLine();
			System.out.print("Department:");
			String dept=scanner.nextLine();
			System.out.print("Salary:");
			double sal=Double.parseDouble(scanner.nextLine());
			empList.add(new Employee(id,name,dept,sal));
		}
		System.out.print("Enter file path to copy the data:");
		String filePath=scanner.nextLine();
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath)))
		{
			oos.writeObject(empList);
			System.out.println("Employee data saved successfully.");
		}
		catch(IOException e)
		{
			System.out.println("Error while saving:"+e.getMessage());
		}
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath)))
		{
			List<Employee> deserializedList=(List<Employee>) ois.readObject();
			System.out.println("\nRetrieved Employee Data:");
			for(Employee emp:deserializedList)
				System.out.println(emp);
		}
		catch(IOException | ClassNotFoundException e)
		{
			System.out.println("Error while reading:"+e.getMessage());
		}
		scanner.close();
	}
}
