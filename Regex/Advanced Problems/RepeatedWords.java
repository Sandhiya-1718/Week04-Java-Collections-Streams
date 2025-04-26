import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class RepeatedWords {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the sentence:");
        String input=scanner.nextLine().toLowerCase();
        input=input.replaceAll("[^a-z\\s]","");
        String[] words=input.split("\\s+");
        Set<String> seenWords=new HashSet<>();
        List<String> repeatedWords=new ArrayList<>();
        for(String word:words)
        {
            if (seenWords.contains(word))
            {
                if (!repeatedWords.contains(word))
                    repeatedWords.add(word);
            }
            else
                seenWords.add(word);
        }
        if(repeatedWords.isEmpty())
            System.out.println("No repeated words found.");
        else
            System.out.println(String.join(", ",repeatedWords));
        scanner.close();
    }
}
