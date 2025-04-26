import java.util.Scanner;
import java.util.regex.*;
public class ReplaceBadWords {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a sentence containing bad words:");
        String input=scanner.nextLine();
        String badWords=String.join("|", "fuck", "shit", "bitch", "asshole", "bastard", "crap", "dick", "piss", "damn", "slut", "douche", "dumb", "stupid", "idiot", "moron", "ugly", "fool", "jerk");
        String patternString="\\b("+badWords+")\\b";
        Pattern pattern=Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(input);
        System.out.println(matcher.replaceAll("****"));
        scanner.close();
    }
}

