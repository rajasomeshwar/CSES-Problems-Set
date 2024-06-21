import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class minimizingCoins {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         long[] dp=new long[values[1]+1];
         Arrays.fill(dp,-1);
      //  System.out.println(TopDown(arr,values[1],dp));
        dp[0]=0;
        for(int i=1;i<=values[1];i++)
        {
        	 dp[i]=Integer.MAX_VALUE;
        	for(int coin : arr)
        	{
        		
        		if(i-coin>=0)
        			 dp[i]=Math.min(dp[i], 1+dp[i-coin]);
        	}
        }
        System.out.println((dp[values[1]]==Integer.MAX_VALUE)?-1:dp[values[1]]);
	}

	private static long TopDown(int[] arr, int money, long[] dp) {
		// TODO Auto-generated method stub
		if(money<0)
			 return Integer.MAX_VALUE;
		if(money==0)
			 return 0;
		if(dp[money]!=-1) return dp[money];
		dp[money]=Integer.MAX_VALUE;
		for(int i : arr)
			dp[money]=Math.min(dp[money],1+TopDown(arr,money-i,dp));
		return dp[money];
		
		
	}

}
