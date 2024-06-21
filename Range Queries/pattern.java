package Pattern;

import java.util.Scanner;

public class pattern
{
	 public static void main(String[] arg)
	 {
		 Scanner scan=new Scanner(System.in);
		 int N=scan.nextInt();
		 int spaces=N-1;
		 for(int i=1;i<=N;i++)
		 {
			for(int j=1;j<=spaces;j++)
				System.out.print("\t");
			for(int j=i;j<i+i;j++)
			{
				System.out.print(j+"\t");
			}
			for(int j=i+i-2;j>=i;j--)
			{
				System.out.print(j+"\t");
			}
			System.out.println();
			spaces--;
		 }
		 spaces=1;
		 for(int i=N-1;i>=1;i--)
		 {
			 for(int j=1;j<=spaces;j++)
					System.out.print("\t");
			for(int j=i;j<i+i;j++)
			{
				System.out.print(j+"\t");
			}
			for(int j=i+i-2;j>=i;j--)
			{
				System.out.print(j+"\t");
			}
			System.out.println();
			spaces++;
		 }
	 }
}