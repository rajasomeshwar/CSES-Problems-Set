import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class treeDistanceI {
   
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	  int size=Integer.parseInt(bf.readLine());
	  HashMap<Integer,List<Integer>> map=new HashMap<>();
	  for(int i=0;i<size-1;i++)
	  {
		  int[] arr=Arrays.stream(bf.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
		  List<Integer> list=map.getOrDefault(arr[0], new ArrayList<Integer>());
		  list.add(arr[1]);
		  map.put(arr[0], list);
		  list=map.getOrDefault(arr[1], new ArrayList<Integer>());
		  list.add(arr[0]);
		  map.put(arr[1], list);
		//  System.out.println(map);
	  }
	  if(size==1)
	  {
		  System.out.print(0);
		  return;
	  }
	  Queue<Integer> queue=new LinkedList<>();
	  int[] visited=new int[size+1];
	  Arrays.fill(visited, -1);
	  queue.add(1);
	  visited[1]=1;
	  int lastNode=-1;
	  while(!queue.isEmpty())
	  {
		  int siz=queue.size();
		  while(siz-->0)
		  {
			  int adj=queue.poll();
			  lastNode=adj;
			  for(int i : map.get(adj))
				   if(visited[i]==-1)
				   {
					   visited[i]=1;
					   queue.add(i);
				   }
		  }
	  }
	 // System.out.println("hi");
	  int[] res=new int[size+1];
	  Arrays.fill(res, Integer.MIN_VALUE);
       int a=bfs(map,lastNode,visited,res);
       bfs(map,a,visited,res);
	 StringBuffer stn=new StringBuffer();
	  for(int i=1;i<=size;i++)
		   stn.append(res[i]+" ");
	  System.out.print(stn);
	  

	}
	private static int bfs(HashMap<Integer,List<Integer>> map,int lastNode,int[] visited,int[] res)
	{
		 Queue<Integer> queue=new LinkedList<>();
		Arrays.fill(visited,-1);
		  visited[lastNode]=1;
		  queue.add(lastNode);
		  int count=0;
		  int ls=0;
		  while(!queue.isEmpty())
		  {
			  count++;
			  int siz=queue.size();
			  while(siz-->0)
			  {
				  
				 int adj=queue.poll();
				 lastNode=adj;
				 for(int j : map.get(adj))
				 {
					 if(visited[j]==-1)
					 {
						 res[j]=Math.max(res[j], count);
						 visited[j]=1;
						 queue.add(j);
					 }
				 }
			  }
		  }
		  return lastNode;
	}

}
