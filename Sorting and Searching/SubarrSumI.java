import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubarrSumI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int [] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int left=0,right=0;
	    long curSum=0,count=0;
	    while(right<arr.length)
	    {
	    	curSum+=arr[right];
	    	while(left<=right && values[1]<curSum)
	    		 curSum-=arr[left++];
	    	right++;
	    	if(curSum==values[1])
	    		 count++;
	    }
	    System.out.println(count);
	}

}
