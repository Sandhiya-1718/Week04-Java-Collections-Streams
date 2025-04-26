import java.util.Scanner;
import java.util.regex.*;
public class ExtractEmail {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the text to find emails:");
        String input=scanner.nextLine();
        String regex="\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        boolean found=false;
        while(matcher.find())
        {
            System.out.println(matcher.group());
            found=true;
        }
        if(!found)
            System.out.println("No email address found.");
        scanner.close();
    }
}
