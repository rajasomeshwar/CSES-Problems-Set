import java.util.Scanner;

public class IncreasingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		Scanner scan =new Scanner(System.in);
		long size=scan.nextLong();
	     long prev=0;
		long min_steps=0;
		long temp=scan.nextLong();
		prev=temp;
		size--;
		while(size-->0)
		{
		    temp=scan.nextLong();
		    min_steps+=(temp>=prev)?0:Math.abs(temp-prev);
		    prev=Math.max(temp,prev);
		}
		System.out.println(min_steps);
	}

}
