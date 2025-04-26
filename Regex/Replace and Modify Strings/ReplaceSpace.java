import java.util.Scanner;
import java.util.regex.*;
public class ReplaceSpace {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter text with multiple spaces:");
        String input=scanner.nextLine();
        System.out.println(input.replaceAll("\\s+"," "));
        scanner.close();
    }
}
