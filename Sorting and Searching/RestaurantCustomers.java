import java.util.Arrays;
import java.util.Scanner;

public class RestaurantCustomers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		long[][] arr=new long[2*t][2];
		int i=0;
		while(t-->0)
		{
			arr[i][0]=scan.nextLong();
			 arr[i++][1]=1;
			arr[i][0]=scan.nextLong();
			arr[i++][1]=-1;
		}
		Arrays.sort(arr,(a,b)->a[0]>b[0]?1:-1);
		int count=0;
		int temp=0;
		for(int i1=0;i1<arr.length;i1++)
		{
			count+=arr[i1][1];
			temp=Math.max(count,temp);
		}
		System.out.println(temp);
		

	}

}
