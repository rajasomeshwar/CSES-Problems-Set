import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

public class Towers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(bf.readLine());
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		TreeMap<Integer,Integer> map=new TreeMap<>();
		for(int i : arr)
		{
		   	var justBeforeUpper=map.higherKey(i);
		 //  	System.out.println(justBeforeUpper);
		   	if(justBeforeUpper!=null)
		   	{
		   		if(map.get(justBeforeUpper)>1)
		   		{
		   			map.put(justBeforeUpper, map.get(justBeforeUpper)-1);
		   		}
		   		else
		   			map.remove(justBeforeUpper);
		   	}
		   	
		   		map.put(i, map.getOrDefault(i, 0)+1);
		   	
		}
         var enter=map.entrySet();
         int max=0;
         for(var i : enter)
         {
        	 max+=i.getValue();
         }
		System.out.println(max);

	}

}
