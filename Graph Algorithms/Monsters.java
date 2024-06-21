import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Monsters {
	static int[][] adjances= {{1,0},{0,1},{0,-1},{-1,0}};
     private static void Bfs(int i,int j,char[][] graph,int[][] monsters)
     {
    	 Queue<int[]> queue=new LinkedList<>();
    	 int[][] visited=new int[graph.length][graph[0].length];
    	 for(int v[] :visited)
    		  Arrays.fill(v, -1);
    	queue.offer(new int[] {i,j});
    	while(!queue.isEmpty())
    	{
    		int size=queue.size();
    		while(size-->0)
    		{
    		int[] currentVisisted=queue.poll();
    		  for(int v[]: adjances)
    		  {
    			  int x=v[0]+currentVisisted[0];
    			  int y=v[1]+currentVisisted[1];
    			   if(IsValid(x,y,graph.length,graph[0].length))
    			   {
    				   if(graph[x][y]=='#' || graph[x][y]=='A'||graph[x][y]=='M') continue;
    				   if(visited[x][y]==-1)
    				   {
    					   visited[x][y]=1+visited[currentVisisted[0]][currentVisisted[1]];
    				   }
    				   else
    				   {
    					   visited[x][y]=Math.min(1+visited[currentVisisted[0]][currentVisisted[1]], visited[x][y]);
    					   
    				   }
    				   if(visited[x][y]!=-1)
    				   monsters[x][y]=visited[x][y];
    				   queue.offer(new int[] {x,y});
    			   }
    		  }
    		}
    		
    	}
     }
	 private static boolean IsValid(int x, int y, int length, int length2) {
		// TODO Auto-generated method stub
		 return (0<=x && x<length && 0<=y && y<length2);
		
	}
	private static void Solver(char[][] graph,int n,int m)
	 {
		 int[][] monsters=new int[n][m];
		 for(int te[] : monsters)
			  Arrays.fill(te, Integer.MAX_VALUE);
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(graph[i][j]=='m')
				 Bfs(i,j,graph,monsters);
			 }
		 }
		 print(monsters);
	 }
	private static void print(int[][] monsters) {
		// TODO Auto-generated method stub
		for(int [] v : monsters)
		{
			for(int j : v)
				System.out.print(j+" ");
			System.out.println();
		}
		
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] size=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int temp=size[0];
		char[][] graph=new char[temp][];
		for(int i=0;i<temp;i++)
			 graph[i]=bf.readLine().toCharArray();
		Solver(graph,size[0],size[1]);
		

	}

}
