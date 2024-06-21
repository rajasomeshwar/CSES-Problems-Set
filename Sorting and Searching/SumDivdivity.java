import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class SumDivdivity {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int  values=Integer.parseInt(bf.readLine());
		long[] arr=Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
	   HashMap<Long,Long> map=new HashMap<>();
	   map.put(0L, 1L);
	   long sum=0,count=0;
	  
	   
	//   System.out.println(Arrays.toString(arr));
	   for(int i=0;i<arr.length;i++)
	   {
		    sum=(arr[i]%values+sum+values+values)%values;
		 
		    	count+=map.getOrDefault(sum, 0L);
		
		    map.put(sum, map.getOrDefault(sum, 0L)+1L);
		    
	   }
	   System.out.println(count);
	}

}
