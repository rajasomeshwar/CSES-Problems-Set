import java.util.Scanner;

public class NumberSprial {
static private	StringBuilder str;
 static private int Solve(long x,long y)
 {
 		/*
 		int nearValue=1;
 		int level=1;
 		
 		while(x-->1)
 		{
 			nearValue+=2*level+1;	
 			level++;
 		}*/
 		//System.out.print(nearValue+" ");
	 if(x%2==0)
	 {
		 
		 str.append(""+((long)Math.pow(Math.max(x, y),2)-(2*(x-1)+1)+y)+"\n");
	 }
	 else
	 {
		 str.append(""+((long)Math.pow(Math.max(x, y),2)-x+1)+"\n");
	 }
	 return 0;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scan=new Scanner(System.in);
    str=new StringBuilder();
    int t= scan.nextInt();
    while(t-->0)
    {
    	long y=scan.nextLong();
    	long x=scan.nextLong();
    	Solve(x,y);
    	
    }
    System.out.println(str);
	}

}
