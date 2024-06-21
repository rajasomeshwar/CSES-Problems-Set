import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IncreasingSubsequence {

	public static void main(String[] args) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int value=Integer.parseInt(bf.readLine());
        int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp=new int[value+1][value+1];
        for(int[] val : dp)
        	 Arrays.fill(val, -1);
       System.out.println( TopDown(arr,0,-1,dp));
      
	}

	private static int TopDown(int[] arr, int i, int prevMaxIndx, int[][] dp) {
 		// TODO Auto-generated method stub
         
		if(i==arr.length) return 0;
         int max=-1;
         if(dp[prevMaxIndx+1][i]!=-1) return dp[prevMaxIndx+1][i];
       
		if(prevMaxIndx==-1) { 
			max=Math.max(1+TopDown(arr,i+1,i,dp),
                     TopDown(arr,i+1,-1,dp));
			return max;
         }
        	 if(arr[prevMaxIndx]<arr[i])
         max=1+TopDown(arr,i+1,i,dp);
        	 max=Math.max(max,TopDown(arr,i+1,prevMaxIndx,dp));
          
         
		return dp[prevMaxIndx+1][i]=max;
	}

}
