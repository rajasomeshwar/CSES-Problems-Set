import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedRangesCheck{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(bf.readLine());
		int[][] arr=new int[value][];
		for(int i=0;i<value;i++)
		{
		   arr[i]=Arrays.stream((bf.readLine()+" "+i).split(" ")).mapToInt(Integer::parseInt).toArray();
		   
		}
		Arrays.sort(arr,(a,b)->{
			if(a[0]>b[0])
				 return 1;
			else
				return (a[0]==b[0])?(a[1]>b[1])?-1:1:-1;
		});
		//for(int[] i : arr)
		//	System.out.println(Arrays.toString(i));
		
	
	   int[] contained=new int[value];
	   Arrays.fill(contained,0);
	   int[] contains=new int[value];
	   Arrays.fill(contains,0);
	   int min=Integer.MAX_VALUE;
	   for(int i=value-1;i>-1;i--)
	   {
		   if(min<=arr[i][1])
		   {
			   contains[arr[i][2]]=1;
		   }
		   min=Math.min(min, arr[i][1]);
	   }
	   int max=Integer.MIN_VALUE;
	   for(int i=0;i<value;i++)
	   {
		   if(max>=arr[i][1])
		   {
			   contained[arr[i][2]]=1;
		   }
		   max=Math.max(max, arr[i][1]);
	   }
	  // System.out.println(Arrays.toString(contained));
	   StringBuilder strn=new StringBuilder();
	   Arrays.stream(contains).forEach(e->strn.append(e+" "));
	   strn.append("\n");
	   Arrays.stream(contained).forEach(e->strn.append(e+" "));
	   System.out.println(strn);
	}
}
/*4
1 6
2 4
4 8
3 6

*/