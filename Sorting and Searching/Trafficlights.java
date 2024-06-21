import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Trafficlights {

	private static final String maxHeap = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] size=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int value=size[0];
		TreeSet<Integer> set=new TreeSet<>();
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->a>b?-1:1);
		int[] Elements=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxHeap.add(size[0]);
		set.add(0);
		set.add(size[0]);
		StringBuilder string=new StringBuilder(size[1]*2);
		for(int i: Elements)
		{
			var Uplmin=set.ceiling(i);
			var lwlimit=set.floor(i);
			int dif=Uplmin-lwlimit;
			maxHeap.remove(dif);
			maxHeap.offer(Uplmin-i);
			maxHeap.offer(i-lwlimit);
			set.add(i);
			string.append(maxHeap.peek()+" ");
		
		//	System.out.println(maxHeap+" tree set  "+set+" cur "+i);
		}
		System.out.println(string);
		
	}

}
