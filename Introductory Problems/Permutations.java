import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan = new Scanner(System.in);
		long t=scan.nextLong();
		//System.out.println("nn");
		StringBuilder str=new StringBuilder();
		if(t==2||t==3)
			System.out.println("NO SOLUTION");
		else
		{
		 for(int i=2;i<=t;i+=2)
			 str.append(i+" ");
		 for(int i=1;i<=t;i+=2)
			 str.append(i+" ");
		 System.out.print(str);
		}
        
	}

}
