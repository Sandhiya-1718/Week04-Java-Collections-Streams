import java.util.Scanner;
public class ValidateHexColorCode {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Hex color code:");
        String input=scanner.nextLine();
        String regex="^#[A-Fa-f0-9]{6}";
        if(input.matches(regex))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}