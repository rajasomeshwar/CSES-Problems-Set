import java.util.Scanner;

public class TrainningZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        long n=scan.nextLong();
        int res=0;
        for(long i=5;i<=n;i*=5)
        	res+=n/i;
        System.out.print(res);
	}

}
