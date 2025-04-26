import java.util.Scanner;
public class SsnNumberValidation {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter ssn number:");
        String input=scanner.nextLine();
        String regex="^(?!000|666|900)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}";
        if(input.matches(regex))
            System.out.println("Valid.");
        else
            System.out.println("Invalid.");
        scanner.close();
    }
}
