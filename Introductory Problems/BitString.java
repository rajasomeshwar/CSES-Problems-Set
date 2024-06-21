import java.util.Scanner;

public class BitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		long t=scan.nextLong();
		long res=1L;
		while(t-->0)
			res=(res*2)%(1000_000_007);
	   System.out.println(res);

	}

}
