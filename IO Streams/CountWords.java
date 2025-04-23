import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class CountWords {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter path to the text file:");
		String file=scanner.nextLine();
		Map<String,Integer> wordCount=new HashMap<>();
		try (BufferedReader br=new BufferedReader(new FileReader(file)))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				line=line.replaceAll("[a-zA-Z]","").toLowerCase();
				String words[]=line.split("\\s+");
				for(String word:words)
				{
					if(!word.isEmpty())
						wordCount.put(word, wordCount.getOrDefault(word,0)+1);
				}
			}
			List<Map.Entry<String,Integer>> sortedWords=new ArrayList<>(wordCount.entrySet());
			Collections.sort(sortedWords,new Comparator<Map.Entry<String,Integer>>()
			{
				public int compare(Map.Entry<String,Integer>a,Map.Entry<String,Integer> b)
				{
					return b.getValue()-a.getValue();
				}
			});
			System.out.println("\nTop 5 Most Frequent Words:");
			for(int i=0;i<Math.min(5,sortedWords.size());i++)
			{
				Map.Entry<String,Integer> entry=sortedWords.get(i);
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file:"+e);
		}
	}

}
