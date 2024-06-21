import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridPath {
  static int mod=1_0000_0000_7;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub]\
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	    int size=Integer.parseInt(bf.readLine());
        char[][] graph=new char[size][];
        int i=0;
        while(i<size)
        	graph[i++]=bf.readLine().replace("\\s+", "").toCharArray();
        int[][] dp=new int[size][size];
      //  for(int va[] : dp)
        //	Arrays.fill(va, -1);
       
    //   System.out.println( TopDown(graph,dp,0,0));
      for(int va[] : dp)
       	Arrays.fill(va, 0);
       for( i=0;i<size;i++)
       {
    	   
    	   for(int j=0;j<size;j++)
    	   {
    		   if(graph[i][j]=='*')
    			    continue;
    		   if(i==0 || j==0) {
    			   if(i==0 && j==0) 
    				   dp[i][j]=1;
    			   else  if(i==0)
    			    dp[i][j]=dp[i][j-1];
    			   else
    				   dp[i][j]=dp[i-1][j];
    			    continue;
    		   }
    	    dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
       
    	   }
       }
    	   System.out.println(dp[size-1][size-1]);
	}

	private static int TopDown(char[][] graph, int[][] dp, int i, int j) {
		
		if(i>=graph.length || j>=graph.length)
			return 0;
		if(graph[i][j]=='*') return 0;
		if(i==graph.length-1 && j==graph.length-1)
			 return 1;
	
		if(dp[i][j]!=-1) return dp[i][j]%mod;
		
		return dp[i][j]=(TopDown(graph,dp,i,j+1)+TopDown(graph,dp,i+1,j))%mod;
		// TODO Auto-generated method stub
		
	}

}
