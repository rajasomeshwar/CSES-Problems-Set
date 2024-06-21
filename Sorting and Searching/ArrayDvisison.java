import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayDvisison {

	//static long value=-1L;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	long[] arr=Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long left=Arrays.stream(arr).reduce(0L,(a,b)->Math.max(a, b));
		long right=Arrays.stream(arr).reduce(0L, (a,b)->a+b);
		//System.out.println(right+" "+left);
		if(values[1]==1) {
			System.out.println(right);
			return;
		}
		if(values[1]==values[0])
		{
			System.out.println(left);
			return;
		}
		while(left<=right)
		{
			//System.out.println(values[1]);
			long mid=(left+right)/2;
			 int Status=IsdivisbleAndSumExit(arr,mid,values[1]);
			 if(Status==0)
			 {
				 right=mid-1;
			 }
			 else
				 left=mid+1;
			// 	System.out.println(Status+" "+right+" "+left);
		}
		System.out.println(left);

	}

	private static int IsdivisbleAndSumExit(long[] arr, long mid, int k1) {
		// TODO Auto-generated method stub
		long cur=0;
	//	System.out.println(mid+" "+k1+" ");
		int k=k1-1;
		for(int i=0;i<arr.length;i++)
		{
			cur+=arr[i];
			if(mid<cur)
			{
				k--;
				cur=arr[i];
			}
			
		//	System.out.print(" "+cur);
		}
		//System.out.println("return "+cur+" "+k);
		
		if(cur>mid)
			return 1;
		if(k<0) return -1;
		return k>=0?0:-1;
		//return 0;
	}

}
