import java.util.Scanner;

public class CoinPiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * use the mod 3 because 1 2 = 3
		 * so that 
		 * 0 0 or 1 2 or 2 1 ratios;
		 */
		Scanner scan = new Scanner(System.in);
		StringBuilder str=new StringBuilder();
		int t=scan.nextInt();
		while(t-->0)
		{
		   long a=scan.nextLong();
		   long b=scan.nextLong();
		   long max=Math.max(a, b);
		   long min=Math.min(a, b);
		   
		   if(min==0|| max==0 || max/2>min)
		   {
			   if(min==0 && max==0)
				    str.append("YES\n");
			   else
				   str.append("NO\n");
			   continue;
		   }
		   else {
			   max%=3;
			   min%=3;
			   if((max==0&& min==0 )||(max==2 && min==1)||(min==2 && max==1))
                 str.append("YES\n");
                 else
                	 str.append("NO\n");
		   } 
		
		}
		System.out.println(str);
	}
	

}
