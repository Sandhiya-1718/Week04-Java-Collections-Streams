import java.util.Scanner;
public class ValidateLicensePlateNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter License Plate Number:");
		String input=scanner.nextLine();
		String regex="^[A-Z]{2}[0-9]{4}";
		if(input.matches(regex))
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}
}
