import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TreeDistanceII {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(bf.readLine());
     HashMap<Integer,List<Integer>> map=new HashMap<>(size+1);
     int[] subTreeAns=new int[size+1];
   
     Arrays.fill(subTreeAns, -1);
     for(int i=0;i<size-1;i++)
     {
    	 int[] temp=Arrays.stream(bf.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
    	 List<Integer> list=map.getOrDefault(temp[0],new ArrayList<>());
    	 list.add(temp[1]);
    	 map.put(temp[0], list);
    	 list=map.getOrDefault(temp[1],new ArrayList<>());
    	 list.add(temp[0]);
    	
    	 map.put(temp[1], list);
     }
     int[] visited=new int[size+1];
     Arrays.fill(visited, -1);
     visited[1]=Integer.MAX_VALUE;
     PrePocess(map,subTreeAns,1,visited);
     int[] res=new int[size+1];
     Arrays.fill(res, -1);
     
     for(int i=1;i<size+1;i++)
    	  solve(subTreeAns,i,res,visited);
     StringBuffer stn=new StringBuffer();
     for(int i=1;i<res.length;++i)
    	 stn.append(res[i]+" ");
     System.out.println(stn);
    	 
     System.out.println(Arrays.toString(subTreeAns)+"\n"+Arrays.toString(visited));
	}

	private static int solve(int[] subTreeAns, int cur, int[] res,int[] par) {
		// TODO Auto-generated method stub
		int count=1;
	  if(res[cur]!=-1) 
		   return 0;
		if(cur==1)
			 return res[1]=subTreeAns[cur];
	    if(res[par[cur]]==-1)
	    	solve(subTreeAns,par[cur],res,par);
	    
		 return res[cur]=subTreeAns[cur]+res[par[cur]];
		
		
	}

	private static int PrePocess(HashMap<Integer, List<Integer>> map, int[] subTreeAns, int curNode,int[] visited) {
		// TODO Auto-generated method stub
		int cost=1;
		for(int i : map.get(curNode))
		{
			if(visited[i]==-1)
			{
				visited[i]=curNode;
				cost+=PrePocess(map,subTreeAns,i,visited);
				
			}
		}
		return subTreeAns[curNode]=cost;
		
	}

}
