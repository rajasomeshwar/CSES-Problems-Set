import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MovieFestival {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Using TreeMap<>
		 */
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine());
        long[][] arr=new long[t][2];
        
        int i=0;
        while(t-->0)
        {
        	String[] values=bf.readLine().split(" ");
        	arr[i][1]=Long.parseLong(values[0]);
        	arr[i][0]=Long.parseLong(values[1]);
        	i++;
        }
        Arrays.sort(arr,(a,b)->a[0]>b[0]?1:(a[0]==b[0])?(a[1]>b[1])?-1:1:-1);
        Arrays.stream(arr).forEach(e->System.out.println(Arrays.toString(e)));
        long ans=0,temp=arr.length,maxIn=0;
        long prevupperBound=0;
        for(i=0;i<arr.length;i++)
        {
        	
            if(i==0)
            {
            	prevupperBound=arr[i][0];
            	ans++;
            }
            else
            {
            	if(arr[i][1]>=prevupperBound)
            	{
            	   prevupperBound=arr[i][0];
            	   ans++;
            	}
            	else
            		prevupperBound=Math.min(arr[i][0], prevupperBound);
            }
            
           //  System.out.println(prevupperBound);
            
        	
        }
        System.out.println(ans);
	}

}
