package Pattern;
import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int temp=2;
		int inc=N-1;
		for(int i=0;i<1;i++){
			for(int j=0;j<N-1;j++){
			System.out.print("\t");
			}
			for(int j=1;j<=1;j++){
				System.out.print(j+"\t");
			}
			for(int j=0;j<N-1;j++){
			System.out.print("\t");
			}
			System.out.println();
		}
		for(int i=1;i<=N-1;i++){
			for(int j=1;j<N-i;j++){
				System.out.print("\t");
			}
			for(int j=temp;j<=2*i+1;j++){
				System.out.print(j+"\t");
			}
			
			for(int j=2*i;j>i;j--){
				System.out.print(j+"\t");
			}
			for(int j=1;j<N-i;j++){
				System.out.print("\t");
			}
			temp++;
			System.out.println();
		}

		for(int i=N-1;i>1;i--){
			for(int j=1;j<=N-i;j++){
				System.out.print("\t");
			}
			for(int j=inc;j<=2*i-1;j++){
				System.out.print(j+"\t");
			}
			
			for(int j=2*i-2;j>i-1;j--){
				System.out.print(j+"\t");
			}
			for(int j=1;j<=N-i;j++){
				System.out.print("\t");
			}
			inc--;
			System.out.println();

		}
		for(int i=0;i<1;i++){
			for(int j=0;j<N-1;j++){
			System.out.print("\t");
			}
			for(int j=1;j<=1;j++){
				System.out.print(j+"\t");
			}
			for(int j=0;j<N-1;j++){
			System.out.print("\t");
			}
			System.out.println();
		}
	
    }
}