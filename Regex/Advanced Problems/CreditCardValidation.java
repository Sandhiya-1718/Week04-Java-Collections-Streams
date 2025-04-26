import java.util.Scanner;
public class CreditCardValidation {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter credit card number:");
        String input=scanner.nextLine();
        String visaPattern="^4\\d{15}";
        String masterPattern="^5\\d{15}";
        if(input.matches(visaPattern))
            System.out.println("Valid Visa Card.");
        else if(input.matches(masterPattern))
            System.out.println("Valid Master Card.");
        else
            System.out.println("Invalid card number");
        scanner.close();
    }
}
