import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class subarrSumII {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	   HashMap<Long,Long> map=new HashMap<>();
	   long sum=0,count=0;
	   map.put(0L,1L);
	   for(int i=0;i<arr.length;i++)
	   { 
		   sum+=arr[i];
		    count+=map.getOrDefault(sum- values[1],(long) 0 );
		    map.put(sum,map.getOrDefault(sum, (long) 0)+1);
		   
	   }
	   System.out.println(count);

	}
  
}
