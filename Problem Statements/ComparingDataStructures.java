import java.util.*;
public class ComparingDataStructures{
	public static void main(String[] args)
	{
		int sizes[]={1000,100000,1000000};
		int target=-1;
		for(int i=0;i<sizes.length;i++)
		{
			int size=sizes[i];
			int arr[]=new int[size];
			HashSet<Integer> hashSet=new HashSet<>();
			TreeSet<Integer> treeSet=new TreeSet<>();
			Random rand=new Random();
			for(int j=0;j<size;j++)
			{
				int val=rand.nextInt(size*2);
				arr[j]=val;
				hashSet.add(val);
				treeSet.add(val);
			}
			System.out.println("Dataset Size: "+size);
			long start=System.nanoTime();
			boolean foundArray=false;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[j]==target)
				{
					foundArray=true;
					break;
				}
			}
			long arrayTime=System.nanoTime()-start;
			System.out.println("Array Search: "+arrayTime/1e6+" ms");
			start=System.nanoTime();
			boolean foundHashSet=hashSet.contains(target);
			long hashSetTime=System.nanoTime()-start;
			System.out.println("HashSet Search: "+hashSetTime/1e6+" ms");
			start=System.nanoTime();
			boolean foundTreeSet=treeSet.contains(target);
			long treeSetTime=System.nanoTime()-start;
			System.out.println("TreeSet Search: "+treeSetTime/1e6+" ms");
			System.out.println();
		}
	}
}
