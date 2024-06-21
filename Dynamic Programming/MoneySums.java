import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MoneySums {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	  /* TreeSet<Long> set=new TreeSet<>();
	   TopDown(arr,n-1,set,-1);
	   System.out.println(set.size());
	   for(long i : set)
		   System.out.print(i+" ");
		   */
	   TreeSet<Integer> list=new TreeSet<>();
		int total=0;
		int[] dp=new int[Arrays.stream(arr).sum()+1];
		Arrays.fill(dp, -1);
		dp[0]=1;
		for(int curMoney : arr)
			
		{ 
			total+=curMoney;
			for(int i=total;i>-1;i--)
			{
				if(i-curMoney>-1 && dp[i-curMoney]!=-1  && dp[i]==-1 )
				{
					dp[i]=1;
					list.add(i);
				}
			}
			
		}
		System.out.println(list.size());
		for(int i: list)
			 System.out.print(i+" ");
		
	}

	private static long TopDown(int[] arr, int i, TreeSet<Long> set,long curSum) {
		 if(curSum!=-1)
		set.add(curSum);
		if(i==-1)
			 return curSum;
		int temp=0;
		if(curSum!=-1)
	   TopDown(arr,i-1,set,curSum+arr[i]);
	   else
		   TopDown(arr,i-1,set,arr[i]);
		TopDown(arr,i-1,set,curSum);
		return curSum;
		
	}

}
