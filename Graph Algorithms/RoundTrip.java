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
class Graph4
{
    private int vertexs;
    public HashSet<Integer>[] graph;
	public Graph4(int vertexs) {
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
public class RoundTrip {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] values=Reading.ReadIntArray();
		Graph4 graph=new Graph4(values[0]);
		while(values[1]-->0)
		{
			int[] arr=Reading.ReadIntArray();
			graph.AddEdgeUnDirected(arr[0], arr[1]);
		}
	//	graph.printGraph();
		int[] visited=new int[values[0]+1];
		Arrays.fill(visited, -1);
		for(int i=1;i<=values[0];i++)
		{
			if(visited[i]==-1) {
				visited[i]=i;
				if(dfs(graph.graph,i,visited))
				{
					int count=2;
					
					StringBuilder stn=new StringBuilder();
					 while(visited[cycle]!=starting)
					 {
						 count++;
						 stn.append(cycle+" ");
						 cycle=visited[cycle];
					 }
					 stn.append(cycle+" ");
					 count++;
					System.out.println(count);//+"\n "+i+" "+starting+" "+cycle+" "+Arrays.toString(visited));
					System.out.println(starting+" "+stn+starting);
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");

	}
   static int cycle,starting;
	private static boolean dfs(HashSet<Integer>[] graph, int vertex, int[] visited) {
		// TODO Auto-generated method stub
		boolean b=false;
		for(int adj : graph[vertex])
		{
			if(visited[adj]==-1)
			{
				//System.out.print(adj+"  ");
				visited[adj]=vertex;
				
				if(dfs(graph,adj,visited)) {
				//	System.out.print(adj+"  ");
			        
					 return true;
				}
			}
			else if(visited[vertex]!=adj)
			{
				cycle=vertex;
				starting=adj;
				
			//	System.out.print("Start "+adj+" "+vertex+" ");
				return true;
				
			}
		}
		return false;
	}

}
