import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadingBooks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(bf.readLine());
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int left=0,right=arr.length-1;
		if(left==right)
		{
			System.out.println(2*arr[left]);
			return;
		}
		long count=0;
		while(left<right)
		{
			long cur=arr[left];
			while(left<right && cur+arr[left]<=arr[right])
			{
				cur+=arr[++left];
				
			}
			//System.out.println("cur "+count);
			if(cur>arr[right])
			{
				count+=cur-arr[right];
			//	System.out.println("cur "+count);
				left++;
			}
			count+=arr[right--];
			//if(left==right)
		// System.out.println(left+" ");
		}
	//	System.out.println(count+" "+left);
		while(left<arr.length)
		 count+=arr[left++];
		System.out.println(count);

	}

}
