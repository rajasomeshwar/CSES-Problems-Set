import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemovalGaming {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int val=Integer.parseInt(bf.readLine());
        int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] dp=new long[arr.length][arr.length];
        for(long i[] : dp)
        	Arrays.fill(i,-1);
        System.out.println(TopDown(arr,0,arr.length-1,dp,1));
	}

	private static long TopDown(int[] arr, int i, int j, long[][] dp,int player) {
		// TODO Auto-generated method stub
		if(i>j)
		{
			return 0;
		}
		if(dp[i][j]!=-1)
			 return dp[i][j];
		 if(player==1)
		return dp[i][j]=Math.max(arr[i]+TopDown(arr,i+1,j,dp,0),arr[j]+TopDown(arr,i,j-1,dp,0));
		 return dp[i][j]=Math.min(TopDown(arr,i+1,j,dp,1), TopDown(arr,i,j-1,dp,1));
		
		
	}

}
