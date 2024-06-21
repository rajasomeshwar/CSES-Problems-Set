import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SUMoftwoValues {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	   String[] st;
	   st=bf.readLine().split(" ");
	   int t=Integer.parseInt(st[0]);
	   int target=Integer.parseInt(st[1]);
	   st=bf.readLine().split(" ");
	   HashMap<Integer,List<Integer>> map=new HashMap<>();
	   int indx=0;
	   String result="IMPOSSIBLE";
	   for( indx=0;indx<st.length;indx++)
	   {
		   int value=Integer.parseInt(st[indx]);
		   List<Integer> list=map.getOrDefault(value, new ArrayList<>());
		   list.add(indx+1);
		   map.put(value, list);
		   if(map.containsKey(target-value))
		   {
			   if(target==2*value)
			   {
				   if(map.get(value).size()>=2)
					   result=map.get(value).get(0)+" "+map.get(value).get(1);
			   }
			   else
				   result=map.get(value).get(0)+" "+map.get(target-value).get(0);
				   }
	   }
	   System.out.println(result);
	   
	}

}
