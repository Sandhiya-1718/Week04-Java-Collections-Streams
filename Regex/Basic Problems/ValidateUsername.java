import java.util.Scanner;
public class ValidateUsername {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter username:");
		String text=scanner.nextLine();
		String regex="^[a-zA-Z][a-zA-Z0-9_]{4,14}";
		if(text.matches(regex))
			System.out.println("Valid username");
		else
			System.out.println("Invalid username");		
		scanner.close();
	}
}
