import java.util.Scanner;
public class ValidateIPAddress {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter IP address:");
        String input=scanner.nextLine();
        String regex="^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)";
        if(input.matches(regex))
            System.out.println("Valid IPv4 address");
        else
            System.out.println("Invalid IPv4 address");
        scanner.close();
    }
}
