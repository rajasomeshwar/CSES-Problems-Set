import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayDescription {
 static int mod=1_0000_0000_7;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		 
		int[]value=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] dp=new int[value[0]][value[1]+1];
		for(int[] va : dp)
		Arrays.fill(va, -1);
		System.out.println(TopDown(0,0,value[1],arr,dp));
		/*dp[0]=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==0)
			{
				dp[i]=3;
			}
			else
			{
				if(Math.abs(arr[i-1]-arr[i])<=1)
					 dp[i]=dp[i-1];
			}
		}
		System.out.println(dp[arr.length-1]);
*/
	}

	private static int TopDown(int curIndx,int prev,int m,int[] arr, int[][] dp) {
		// TODO Auto-generated method stub
		if(curIndx>=arr.length)
			 return 1;
		int count=0;
		if(  dp[curIndx][prev]!=-1) return dp[curIndx][prev];
		if(arr[curIndx]==0)
		{
			if(curIndx==0)
			{
				for(int i=1;i<=m;i++)
				count=(count+TopDown(curIndx+1,i,m,arr,dp))%mod;
			}
			else
				{
			
				count=(count+TopDown(curIndx+1,prev,m,arr,dp))%mod;
				if(prev-1>=1)
				count=(count+TopDown(curIndx+1,prev-1,m,arr,dp))%mod;
				if(prev+1<=m)
				count=(count+TopDown(curIndx+1,prev+1,m,arr,dp))%mod;
				
				}
		}
		else
		{
			if(curIndx==0|| Math.abs(prev-arr[curIndx])<=1)
				 return dp[curIndx][prev]=TopDown(curIndx+1,arr[curIndx],m,arr,dp)%mod;
		}
		return dp[curIndx][prev]=count%mod;
		
		
	}

}
