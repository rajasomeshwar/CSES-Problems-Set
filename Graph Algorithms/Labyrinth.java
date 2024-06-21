import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Labyrinth {

	public static void main(String[] arg) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] dimension=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		char[][] graph=new char[dimension[0]][];
		int[][] previous=new int[dimension[0]][dimension[1]];
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
				 if(graph[i][j]=='#' || graph[i][j]=='.')
					  continue;
				 if(graph[i][j]=='A')
				 if(Bfs(i,j,graph,visited, previous))
				 {
					 System.out.println("YES");
					// System.out.println("next "+i+" "+j);
					 StringBuilder stn=new StringBuilder();
					 
 					while(x!=i || y!=j) {
						 stn.append(s.charAt(previous[x][y]));
					//	 System.out.println("1 " +x+" "+y);
						 int x1=x;
					    x-=ways[(previous[x][y])][0];
					    y-=ways[(previous[x1][y])][1];
					   
					 //   System.out.println(x+" "+y);
					 }
 					//stn.append(s.charAt(previous[x][y]));
 					stn.reverse();
 					System.out.println(stn.length());
					 System.out.println(stn);
					 return ;
				 }
	//System.out.println(i+" "+j+" \n next ");
			 }
		}
      System.out.println("NO");
	}
static int x,y;
	static int[][] ways= {{1,0},{0,1},{-1,0},{0,-1}};
  static String s="DRUL";
	private static boolean Bfs(int i, int j, char[][] graph, boolean[][] visited,int[][] previous) {
		// TODO Auto-generated method stub
		
	   visited[i][j]=true;
	  // System.out.println("move "+i+" "+j);
	   LinkedList<int[]> queue=new LinkedList<>();
	   queue.add(new int[] {i,j});
	   while(!queue.isEmpty()) {
		    i=queue.peek()[0];
		   j=queue.poll()[1];
		   int count=0;
	   for(int[] way:ways) {
		   if( IsValid(i+way[0],j+way[1],graph) && !visited[i+way[0]][way[1]+j] && graph[way[0]+i][way[1]+j]=='.')
		   {
			visited[i+way[0]][j+way[1]]=true;
			queue.add(new int[] {i+way[0],j+way[1]});
			previous[i+way[0]][j+way[1]]=count;
			//System.out.println(s.charAt(count));
			 //System.out.println((i+way[0])+" "+(j+way[1]) );
		   }
		   else if(IsValid(i+way[0],j+way[1],graph) && graph[way[0]+i][way[1]+j]=='B')
		   {
			   previous[i+way[0]][j+way[1]]=count;
		
			  x=way[0]+i;
			   y=way[1]+j;
			   return true;
		   }
	   count++;
	   }
	   
	   }
	   return false;
	   
		
	}
	private static boolean IsValid(int i, int j, char[][] graph) {
		 if(i>=graph.length || j>=graph[0].length) return false;
		   if(i<0 ||j<0) return false;
		   return true;
	}
}
