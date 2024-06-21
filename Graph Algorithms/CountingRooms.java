import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class CountingRooms {
	
public static void main(String[] arg) throws IOException {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	int[] dimension=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	char[][] graph=new char[dimension[0]][];
	int i=0;
	while(i<dimension[0])
	{
            graph[i++]=bf.readLine().replace("\\s+","").toCharArray();
	}
	boolean[][] visited=new boolean[graph.length][graph[0].length];
	for(boolean[] v : visited)
		 Arrays.fill(v, false);
	int NoofRooms=0;
	for( i=0;i<graph.length;i++)
	{
		 for(int j=0;j<graph[i].length;j++)
		 {
			 if(graph[i][j]=='#')
				  continue;
			 if(visited[i][j])
				  continue;
			 NoofRooms++;
			 Bfs(i,j,graph,visited);
//System.out.println(i+" "+j+" \n next ");
		 }
	}
	System.out.println(NoofRooms);
}

static int[][] ways= {{1,0},{0,1},{-1,0},{0,-1}};
private static void Bfs(int i, int j, char[][] graph, boolean[][] visited) {
	// TODO Auto-generated method stub
	
   visited[i][j]=true;
  // System.out.println("move "+i+" "+j);
   LinkedList<int[]> queue=new LinkedList<>();
   queue.add(new int[] {i,j});
   while(!queue.isEmpty()) {
	    i=queue.peek()[0];
	   j=queue.poll()[1];
   for(int[] way:ways)
	   if( IsValid(i+way[0],j+way[1],graph) && !visited[i+way[0]][way[1]+j] && graph[way[0]+i][way[1]+j]=='.')
	   {
		visited[i+way[0]][j+way[1]]=true;
		queue.add(new int[] {i+way[0],j+way[1]});
	   }
   
   }
   
   
	
}
private static boolean IsValid(int i, int j, char[][] graph) {
	 if(i>=graph.length || j>=graph[0].length) return false;
	   if(i<0 ||j<0) return false;
	   return true;
}
}
