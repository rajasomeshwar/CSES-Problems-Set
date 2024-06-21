import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemovingDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int value=Integer.parseInt((new BufferedReader(new InputStreamReader(System.in)).readLine()));
	   long[] dp=new long[value+1];
	   Arrays.fill(dp, -1);
	//	System.out.println(TopDown(value,dp));
		dp[0]=0;
		for(int i=1;i<=value;i++)
		{
		     int temp=i;
		     dp[i]=Integer.MAX_VALUE;
		     while(temp!=0)
		     {
		    	 dp[i]=Math.min(dp[i], 1+dp[i-temp%10]);
		    	 temp/=10;
		     }
		     
		}
		System.out.println(dp[value]);
	
	}
	private static long TopDown(int value,long[] dp)
	{
		if(value<=0) return 0;
		if(dp[value]!=-1) return dp[value];
		int temp=value;
		dp[value]=Integer.MAX_VALUE;
		while(temp!=0)
		{
			dp[value]=Math.min(dp[value], 1+TopDown(value-temp%10,dp));
			temp/=10;
		}
		return dp[value];
	}

}
