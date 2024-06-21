import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class xfromy {
	public static void main(String[] arg) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String x=bf.readLine();
		String y=bf.readLine();
		int[] rs=Arrays.stream(bf.readLine().replaceAll("\\s+"," ").split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(Solver(x,y,rs[0],rs[1]));
		
	}

	private static String Solver(String x, String y, int s, int r) {
		// TODO Auto-generated method stub
		int ans=0;
	    HashSet<Integer>[] hash=new HashSet[26];
	    for(int i=0;i<26;i++)
	    	hash[i]=new HashSet<>();
	    for(int i=0;i<y.length();i++)
	    {
	    	hash[y.charAt(i)-'a'].add(i);
	    }
	    for(int i=0;i<x.length();i++)
	    {
	    	if(hash[x.charAt(i)-'a'].isEmpty())
	    		 return "Impossible";
	    	 int local=Integer.MAX_VALUE;
	    	 int i1=i;
	    	for(int j : hash[x.charAt(i)-'a'])
	    	{
	    		int left=j;
	    		int temp=i;
	    		while(left>-1 &&  temp<x.length() && x.charAt(temp)==y.charAt(left))
	    		{
	    			left--;
	    			temp++;
	    		}
	    		int count=(temp-i)*r;
	    		int right=j;
	    		int temp1=i;
	    		
	    		while(right<y.length()&& temp1<x.length()  && x.charAt(temp1)==y.charAt(right))
	    		{
	    			temp1++;
	    			right++;
	    		}
	    		//System.out.println(temp1+" "+right+" l "+left+"  "+temp);
	    		int count1=(temp1-i)*s;
	    		System.out.println(x.charAt(i)+" "+i+" "+count+" "+count1);
	    		if(count<count1)
	    		{
	    			if(local>count)
	    			{
	    				local=count;
	    				i1=temp;
	    			}
	    		}
	    		else if(count>count1)
	    		{
	    			if(local>count1)
	    			{
	    				local=count1;
	    				i1=temp1;
	    			}
	    		
	    			
	    		}
	    		else
	    		{
	    			if((temp-i)<(temp1-i))
	    			{
	    				if(local>count)
		    			{
		    				local=count;
		    				i1=(temp1-i);
		    			}
	    			}
	    			else
	    				{if(local>count)
	    			{
	    				local=count;
	    				i1=(temp-i);
	    			}
	    				}
	    		}
	    	}
	    	ans+=local;
	    	i=i1-1;
	    //	System.out.println(i);
	    }
		return ""+ans;
	    
		
	}

}

