import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxsumSubarr {
/*
 * 8
-   -1 3 -2 5 3 -5 2 2
     -1 
        3 
        
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int arrSize=Integer.parseInt(bf.readLine());
		//String[] stn=bf.readLine().split(" ");
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
		long maxSum=Integer.MIN_VALUE,sum=Integer.MIN_VALUE;
		int left=0;
	    sum=0;
		for(int i=0;i<arrSize;i++)
		{
			
			 if(sum+arr[i]>0)
			{
				 sum+=arr[i];
				 maxSum=Math.max(maxSum, sum);
				
			}
			else {
				if(sum!=0)
				maxSum=Math.max(maxSum, Math.max(sum, arr[i]));
				else
					maxSum=Math.max(maxSum, arr[i]);
				sum=0;
				
				
			}
		//	 System.out.println(" left "+left+" right "+i+" sum "+sum);
			
		}
		if(sum!=0)
		maxSum=Math.max(maxSum, sum);
		System.out.println(maxSum);

	}

}
