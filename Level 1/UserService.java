import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class UserService {
	static class UserAlreadyExistsException extends Exception
	{
		public UserAlreadyExistsException(String message)
		{
			super(message);
		}
	}
	
	static class UserNotFoundException extends Exception
	{
		public UserNotFoundException(String message)
		{
			super(message);
		}
	}
	
	private Set<String> userDatabase=new HashSet<>();
	public void registerUser(String username) throws UserAlreadyExistsException
	{
		if(userDatabase.contains(username))
			throw new UserAlreadyExistsException("User "+username+" already exists.");
		userDatabase.add(username);
		System.out.println("User "+username+" registered successfully.");
	}
	
	public void checkUserExistence(String username) throws UserNotFoundException
	{
		if(!userDatabase.contains(username))
			throw new UserNotFoundException("User "+username+" not found.");
		System.out.println("User "+username+" exists in the system.");
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		UserService userService=new UserService();
		while(true)
		{
			System.out.println("\n----User Service Menu----");
			System.out.println("1. Register User");
			System.out.println("2. Check User Existence");
			System.out.println("3. Exit");
			System.out.print("Enter your choice:");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter username to register:");
				String user=scanner.nextLine();
				try { userService.registerUser(user); }
				catch(UserAlreadyExistsException e) { System.out.println("Error:"+e.getMessage()); }
				break;
			case 2:
				System.out.print("Enter username to check:");
				String checkUser=scanner.nextLine();
				try { userService.checkUserExistence(checkUser); }
				catch(UserNotFoundException e) { System.out.println("Error:"+e.getMessage()); }
				break;
			case 3:
				System.out.println("Exiting the system.");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice.Please try again.");
			}
		}
	}
}
