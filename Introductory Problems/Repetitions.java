import java.util.Scanner;

public class Repetitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scan = new Scanner(System.in);
       String s=scan.next();
       int max=0;
       int left=0;
       for(int right=0;right<s.length();right++)
       {
    	   if(s.charAt(left)!=s.charAt(right))
    	   {
    		   left=right;
    	   }
    	   max=Math.max(max, right-left+1);
       }
       System.out.println(max);
	}

}
