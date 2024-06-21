import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EditDistances {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s1=bf.readLine();
        String s2=bf.readLine();
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i[]:dp)
        	Arrays.fill(i, -1);
        System.out.println(TopDown(s1,s2,0,0,dp));
      BottomUp(s1, s2, dp);
       System.out.println(dp[s1.length()][s2.length()]);//+(Math.abs(s1.length()-s2.length())));
	}

	private static void BottomUp(String s1, String s2, int[][] dp) {
		for(int i=0;i<=s1.length();i++)
		    {
		    	for(int j=0;j<=s2.length();j++)
		    	{
		    		if(i==0||j==0)
		    		{
		    			if(i==0)
		    			dp[i][j]=j;
		    			else
		    				dp[i][j]=i;
		    		}
		    		else	if(s1.charAt(i-1)==s2.charAt(j-1))
		    		{
		    			dp[i][j]=dp[i-1][j-1];
		    		}
		    		else
		    		{
		    			dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
		    		}
		    	}
		    }
		
	}

	private static int TopDown(String s1, String s2, int i, int j,int[][]dp) {
		// TODO Auto-generated method stub
		if(i>=s1.length() || j>=s2.length())
			{
			 if(i==s1.length())return s2.length()-j;
			 else return s1.length()-i;
			}
		if(dp[i][j]!=-1) return dp[i][j];
		int count=Integer.MAX_VALUE;
		if(s1.charAt(i)==s2.charAt(j))
		{
			count=Math.min(count, TopDown(s1,s2,i+1,j+1,dp));
		}
		else {
		count=Math.min(count,1+TopDown(s1,s2,i+1,j,dp));
		count=Math.min(count,1+TopDown(s1,s2,i,j+1,dp));
		count=Math.min(1+TopDown(s1,s2,i+1,j+1,dp), count);
		}
		return dp[i][j]=count;
	}

}
