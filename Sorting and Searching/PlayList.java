import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class PlayList {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
       BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int size=Integer.parseInt(bf.readLine());
       int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       HashMap<Integer,Integer> map=new HashMap<>();
       int left=0,right=0;
       int maxAns=0;
       while(right<size)
       {
    	   if(!map.containsKey(arr[right]))
    		   {
    		      map.put(arr[right], right);
    		   }
    	   else
    	   {
    		   if(left<=map.get(arr[right]))
    		   {
    			   left=map.get(arr[right])+1;
    		   }
    		  
    		   map.put(arr[right], right);
    		   
    	   }
    	   
    		   maxAns=Math.max(maxAns, right-left+1);
    		  // System.out.println(maxAns+" "+map+" "+left+"   "+right);
    		   right++;
    		   
       }
       System.out.println(maxAns);
       }

}
