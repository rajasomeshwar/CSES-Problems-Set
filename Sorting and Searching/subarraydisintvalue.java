import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class subarraydisintvalue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int[] value=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    HashMap<Integer,Integer> map=new HashMap<>();
	    int left=0,right=0;
	    long cost=0;
	    while(right<arr.length) {
	    	map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
	    	if(map.size()>value[1])
	    	{
	    		while(left<right && map.size()>value[1])
	    		{
	    			map.put(arr[left], map.get(arr[left])-1);
	    			if(map.get(arr[left])==0)
	    				 map.remove(arr[left]);
	    			left++;
	    		}
	    		
	    	}
	    	cost+=(right-left+1);
	    	right++;
	    }
	    System.out.println(cost);
	  
	}


}
