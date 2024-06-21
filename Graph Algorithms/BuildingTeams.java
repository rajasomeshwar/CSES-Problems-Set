import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

class  Reading
{
	private static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    Reading()
    {
      bf=new BufferedReader(new InputStreamReader(System.in));	
    }
    {
    	bf=new BufferedReader(new InputStreamReader(System.in));	
    }
    public static int ReadInt() throws NumberFormatException, IOException
    {
    	return Integer.parseInt(bf.readLine().replaceAll("\\s+",""));
    }
   static public int[] ReadIntArray() throws Exception
    {
    	return Arrays.stream(bf.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
		//return null;
    }
    static public String ReadString() throws Exception
    {
    	return bf.readLine();
    }
}
class Graph2
{
    private int vertexs;
    public HashSet<Integer>[] graph;
	public Graph2(int vertexs) {
		// TODO Auto-generated constructor stub
		this.vertexs=vertexs;
		graph=new HashSet[vertexs+1];
		for(int i=0;i<=vertexs;i++)
			graph[i]=new HashSet<>();
	}
	public void AddEdgeDirected(int vertex1,int vertex2)
	{
		graph[vertex1].add(vertex2);
	}
	public void AddEdgeUnDirected(int vertex1,int vertex2)
	{
		AddEdgeDirected(vertex1,vertex2);
		AddEdgeDirected(vertex2,vertex1);
	}
	public boolean RemoveEdgeDirected(int vertex1,int vertex2)
	{
		if(graph[vertex1].contains(vertex2))
		{
			graph[vertex1].remove(vertex2);
			return true;
		}
		return false;
	}
	public boolean RemoveEdgeUnDirected(int vertex1,int vertex2)
	{
	        return RemoveEdgeDirected(vertex1,vertex2) && RemoveEdgeDirected(vertex2,vertex1);
	}
	public StringBuilder Bfsways;
	public int[] Bfs(int vertex)
	{
		Bfsways=new StringBuilder();
		LinkedList<Integer> queue=new LinkedList<>();
		int[] visited=new int[this.vertexs+1];
		Arrays.fill(visited, -1);
		queue.add(vertex);
		visited[vertex]=vertex;
		Bfsways.append(vertex+" ");
		while(!queue.isEmpty())
		{
			int ver=queue.poll();
			for(int adj:graph[ver])
			{
				if(visited[adj]==-1)
				{
					visited[adj]=ver;
					queue.add(adj);
					Bfsways.append(adj+" ");
				}
			}
		}
		return visited;// ways to bfs  previouse
	}
	public void printGraph()
	{
		for(int i=0;i<=vertexs;i++)
		{
			System.out.println(i+"-> "+graph[i]);
		}
	}
	
	
}
public class BuildingTeams {
   static int[] ans;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] values=Reading.ReadIntArray();
		HashSet<Integer> set1,set2;
		set1=new HashSet<>();
	    set2=new HashSet<>();
	    ans=new int[values[0]+1];
	    Arrays.fill(ans,-1);
	    int temp=values[0];
	    Graph2 graph=new Graph2(temp);
	    while(values[1]-->0)
	    {
	    	int[] arr=Reading.ReadIntArray();
	    	
	    	graph.AddEdgeUnDirected(arr[0], arr[1]);
	    }
	    
	    for(int i=1;i<=temp;i++)
	    {
	    	if(ans[i]==-1)
	    	if(dfs(graph.graph,i,1))
	    	{
	    		System.out.println("IMPOSSIBLE");
	    		return;
	    	}
	    }
	    for(int i=1;i<=temp;i++)
	    	System.out.print(ans[i]+" ");
	}
	private static boolean dfs(HashSet<Integer>[] graph,int vertex,int color)
	{
		boolean b=false;
	    for(int adj : graph[vertex])
	    {
	    	if(ans[adj]==-1)
	    	{
	    		ans[adj]=(color==1)?2:1;
	    		b=dfs(graph,adj,(color==1)?2:1)||b;
	    	}
	    	else
	    	{
	    		if(color==2) {
	    		if(ans[adj]!=1) return true;
	    		}
	    		else
	    			 if((ans[adj]!=2)) return true;
	    		
	    			 
	    	}
	    }
	    return b;
	}

}
