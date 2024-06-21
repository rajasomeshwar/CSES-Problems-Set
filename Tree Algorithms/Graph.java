import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph
{
    private int vertexs;
    public HashSet<Integer>[] graph;
	public Graph(int vertexs) {
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