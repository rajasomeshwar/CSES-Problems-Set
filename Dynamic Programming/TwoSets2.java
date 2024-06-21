import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSets2 {
 static int mod=1_000_000_007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(bf.readLine());
       long[][] dp=new long[value*(value+1)/2+1][value+1];
       for(long val[] :dp)
    	    Arrays.fill(val, -1);
       if((value*(value+1)/2)%2==0)
    	   System.out.println(TopDown(1,value*(value+1)/2/2,value,dp));
       else
    	   System.out.println(0);
       
	}

	private static long TopDown(int i, int requiredSum, int limit, long[][] dp) {
		// TODO Auto-generated method stub
		if(requiredSum<0 || i>limit)
			 return 0;
		if(requiredSum==0) return 1;
		if(dp[requiredSum][i]!=-1) return dp[requiredSum][i]%mod;
		//System.out.println(i+" "+limit+" "+requiredSum);
		return dp[requiredSum][i]=(TopDown(i+1,requiredSum,limit,dp)%mod+TopDown(i+1,requiredSum-i,limit,dp)%mod)%mod;
       		
	}

}
