import java.util.Scanner;
import java.util.regex.*;
public class ExtractCapitalizedWords {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String sentence=scanner.nextLine();
        String regex="\\b[A-Z][a-z]*\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher((sentence));
        StringBuilder result=new StringBuilder();
        while(matcher.find())
        {
            if(result.length()>0)
                result.append(", ");
            result.append(matcher.group());
        }
        if(result.length()>0)
            System.out.println(result.toString());
        else
            System.out.println("No capitalized words found.");
        scanner.close();
    }
}
