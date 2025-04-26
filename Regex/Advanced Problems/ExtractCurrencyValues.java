import java.util.Scanner;
import java.util.regex.*;
public class ExtractCurrencyValues {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a sentence containing price:");
        String input=scanner.nextLine();
        String regex="([$€₹£¥]\\d+(\\.\\d{1,2})?)|(\\d+(\\.\\d{1,2}))";
        Pattern patter=Pattern.compile(regex);
        Matcher matcher= patter.matcher(input);
        StringBuilder result=new StringBuilder();
        while(matcher.find())
        {
            if(!result.isEmpty())
                result.append(", ");
            result.append(matcher.group());
        }
        if(!result.isEmpty())
            System.out.println(result);
        else
            System.out.println("No currency values found.");
        scanner.close();
    }
}
