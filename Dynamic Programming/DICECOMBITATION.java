
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DICECOMBITATION {
static int mod=1_0000_0000_7;
static int[] dicesPossiblity={1,2,3,4,5,6};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	   int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	   int[] dp=new int[n+1];
	   Arrays.fill(dp,-1);
	  // System.out.println(TopDown(n,dp));
	  System.out.println(BottomUp(n,dp));

	}
	private static int BottomUp(int n, int[] dp) {
		
		// TODO Auto-generated method stub
		dp[1]=1;
		dp[0]=0;
		for(int i=1;i<=n;i++)
		{
			int prev=i-1;
			if(i<=6)
			dp[i]=1;
			else
				dp[i]=0;
			while(prev>=i-6 && prev>=0)
				 dp[i]=(dp[i]+dp[prev--])%mod;
		}
		return dp[n];
		
	}
	private static int TopDown(int n, int[] dp) {
		// TODO Auto-generated method stub
		if(n<0)
			return 0;
		if(n==0)
			 return 1;
		if(dp[n]!=-1) return dp[n]%mod;
		int count=0;
		for(int i : dicesPossiblity )
		{
			if(n-i>=0)
				count=(count+TopDown(n-i,dp)%mod);
				
		}
		return dp[n]=(count)%mod;
	
	}

}
