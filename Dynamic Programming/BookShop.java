import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookShop {

	public static void main(String[] args) throws IOException {
	


				BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
				int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[] weight=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[] profit=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		     //    long[][] dp=new long[values[1]+1][values[0]+1];
		     
		       //  System.out.println(TopDown(values[1],weight,profit,dp,values[0]-1));
		       var dp=new int[values[0]+1][values[1]+1];
		        int[][] comn=new int[values[0]][values[0]];
		        for(int i=0;i<weight.length;i++) {
		        	 comn[i][0]=weight[i];
		            comn[i][1]=profit[i];
	          }
		       // Arrays.sort(comn,(a,b)->a[0]>b[0]?-1:1);
		         for(int temp[] : dp)
		        	  Arrays.fill(temp,0);
		         for(int i=0;i<=values[0];i++)
		         {
		        	 for(int j=0;j<=values[1];j++)
		        	 {
		        		 if(i==0||j==0)
		        			  dp[i][j]=0;
		        		 else
		        		 {
		        			 if(j-weight[i-1]>=0)
		        			 {
		        				 dp[i][j]=Math.max(dp[i][j], profit[i-1]+dp[i-1][j-weight[i-1]]);
		        			 }
		        			 dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
		        		 }
		        		// System.out.print(dp[i][j]+" ");
		        	 }
		        	// System.out.println();
		         }
		         System.out.println(dp[weight.length][values[1]]);
			}

	private static long TopDown(int curWeight, int[] weight, int[] profit, long[][] dp,int n) {
		// TODO Auto-generated method stub
		 if(curWeight<0 || n<0)
			  return 0;
		 if(dp[curWeight][n]!=0) return dp[curWeight][n];
		 long temp=0;
		 if(curWeight-weight[n]>=0)
			  temp=Math.max(temp, profit[n]+TopDown(curWeight-weight[n],weight,profit,dp,n-1));
		 temp=Math.max(temp,TopDown(curWeight,weight,profit,dp,n-1));
		return dp[curWeight][n]=temp;
		 
	}

}
