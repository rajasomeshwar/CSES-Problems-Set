import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingCoinsum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(bf.readLine());
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long curSum=0;
		int right=0;
		Arrays.sort(arr);
		while(right<arr.length)
		{
			if(curSum+1<arr[right])//||!(right>1&&(arr[right]==arr[right-1]||arr[right]-1==arr[right])))
			{
				System.out.println(curSum+1);
				return;
			}
			curSum+=arr[right];
			right++;
		}
		System.out.println(curSum+1);
		
     //  1 2 2 7 9
       //  3 5 
	}

}
