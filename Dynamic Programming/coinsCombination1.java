import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class coinsCombination1{
	static long mod=1_0000_0000_7;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         long[] dp=new long[values[1]+1];
         Arrays.fill(dp,-1);
         Arrays.sort(arr);
       //System.out.println(TopDown(arr,values[1],dp));
        dp[0]=1;
        for(int i=1;i<=values[1];i++)
        {
        	 dp[i]=0;
        	for(int coin : arr)
        	{
        		
        		
        		if(i-coin>=0  && dp[i-coin]!=-1)
        			dp[i]=(dp[i]+dp[i-coin])%mod;
        	//	if(coin<i)
        		//	break;
        	}
        	if(dp[i]==0)
        		dp[i]=-1;
        	
        }
        System.out.println((dp[values[1]]==Integer.MAX_VALUE||dp[values[1]]==-1)?0:dp[values[1]]);
	}

	private static long TopDown(int[] arr, int money, long[] dp) {
		// TODO Auto-generated method stub
		if(money<0)
			 return -Integer.MAX_VALUE;
		if(money==0)
			 return 1;
		if(dp[money]!=-1) return dp[money];
		dp[money]=Integer.MAX_VALUE;
	     long temp=0;
		for(int i : arr) {
			long local=TopDown(arr,money-i,dp);
			if(local<0);
			else
				 temp=(temp+local)%mod;
		}
		return dp[money]=temp;
	}

}
