import java.util.Scanner;
import java.util.regex.*;
public class DatesExtraction {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter text with dates:");
        String input=scanner.nextLine();
        String regex="\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        StringBuilder result=new StringBuilder();
        while(matcher.find())
        {
            if(result.length()>0)
                result.append (", ");
            result.append(matcher.group());
        }
        if(result.length()>0)
            System.out.println(result.toString());
        else
            System.out.println("No dates found.");
        scanner.close();
    }
}
