import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sticklengths {
static 	long value=0L;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		bf.readLine();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
		Arrays.sort(arr);
		//1 2 3 4 4 4 
		
			int median=arr[arr.length/2];
		//	long value=0L;
			Arrays.stream(arr).forEach(e-> value+=Math.abs(median-e));
		   
		 if(arr.length%2==1) {
			 System.out.println(value);
			  return ;
		 }
			  
		
			int median1=arr[arr.length/2-1];
			long temp=value;
			value=0;
			Arrays.stream(arr).forEach(e-> value+=Math.abs(median-e));
		System.out.println(Math.max(value, temp));
		}
}


