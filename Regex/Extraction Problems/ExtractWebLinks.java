import java.util.Scanner;
import java.util.regex.*;
public class ExtractWebLinks {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the text:");
        String text=scanner.nextLine();
        String regex="https?://(www\\.)?([a-zA-Z0-9.-]+)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
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
            System.out.println("No webpage links found.");
        scanner.close();
    }
}
