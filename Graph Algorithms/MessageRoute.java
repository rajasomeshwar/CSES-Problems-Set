import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class graph
{
    private int vertexs;
    private HashSet<Integer>[] graph;
    public graph()
    {
    	
    }
	public graph(int vertexs) {
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
public class MessageRoute {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int[] value=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int vertex=value[0];
        graph graph=new graph(vertex);
        while(value[1]-->0)
        {
        	 int[] value1=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	 graph.AddEdgeUnDirected(value1[0], value1[1]);
        }
       // graph.printGraph();
       int[] path=graph.Bfs(1);
    //   System.out.println(Arrays.toString(path));
      // System.out.println(graph.Bfsways);
       if(path[vertex]==-1)
       {
    	   System.out.println("IMPOSSIBLE");
    	   return ;
       }
       StringBuilder stn=new StringBuilder();
       int count=1;
       List<Integer> list=new ArrayList<>();
       while(path[vertex]!=vertex)
       {
    	   list.add(vertex);
    	   count++;
    	   vertex=path[vertex];
       }
         list.add(vertex);
    	  System.out.println(count);
    	 for(int i=count-1;i>-1;i--)
    		 stn.append(list.get(i)+" ");
    	 
    	 System.out.println(stn);
        
        
	}

}
