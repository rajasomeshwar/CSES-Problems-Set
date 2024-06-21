import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StaticRangeSumQueries {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int val[]=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	long[] prefix=new long[arr.length];
		prefix[0]=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			prefix[i]=prefix[i-1]+arr[i];
		}
		StringBuffer stn=new StringBuffer(val[1]*2);
		while(val[1]-->0)
		{
			int[] temp=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			stn.append(prefix[temp[1]-1]-prefix[temp[0]-1]+arr[temp[0]-1]+"\n");
		}
		System.out.println(stn);

	}

}
