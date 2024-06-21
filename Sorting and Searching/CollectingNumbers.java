import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CollectingNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(bf.readLine());
        int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] indx=new int[size];
        for(int i=0;i<arr.length;i++)
        {
        	indx[arr[i]-1]=i;
        }
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
                   while(i+1<arr.length && (indx[i]+1)%size==indx[i+1]%size)
                       {
	               i++;
                }
                   max++;
        		

        }
        System.out.println(max);
	}

}
