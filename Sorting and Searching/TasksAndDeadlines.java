import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TasksAndDeadlines {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(bf.readLine());
		int[][] arr=new int[value][];
		for(int i=0;i<value;i++)
		{
			arr[i]=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
		}
		Arrays.sort(arr,(a,b)->a[0]>b[0]?1:(a[0]==b[0])?a[1]>b[1]?1:-1:-1);
	    long cost=0;
	    long complete=0;
	    for(int i=0;i<arr.length;i++)
	    {
	    	 complete+=arr[i][0];
	    	cost+=(arr[i][1]-complete);
	    }
	    System.out.println(cost);
		

	}

}
