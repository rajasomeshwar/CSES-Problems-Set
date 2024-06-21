import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SUMOfThree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        long[] value=Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
	    long[] arr1=Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
	    long[][] arr=new long[arr1.length][2];
	   for(int i=0;i<value[0];i++)
	   {
		   arr[i][0]=arr1[i];
		   arr[i][1]=i+1;
	   }
        Arrays.sort(arr,(a,b)->a[0]>b[0]?1:-1);
       
        int i=0,j=i,k=arr.length-1;
        while(i<k)
        {
             j=i+1;
             long sum=arr[k][0]+arr[i][0];
             while(j<k)
             {
            	
            	 sum=arr[k][0]+arr[i][0]+arr[j][0];
            	if(sum==value[1])
            	{
            		System.out.println(arr[i][1]+" "+arr[j][1]+" "+arr[k][1]);
            		return;
            	}
            	if(sum>value[1])
            		 break;
            	j++;
             }
             if(sum<value[1])
             {
            	 i++;
             }
             else
            	 k--;
        }
        System.out.println("IMPOSSIBLE");
	}

}
