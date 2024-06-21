import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class UnionFind
{
	private int n;
private	int[] parents;
	private int[] rank;
	UnionFind(int n)
	{
		this.n=n+1;
		this.parents=new int[n+1];
		Arrays.fill(parents, -1);
		this.rank=new int[n+1];
		Arrays.fill(rank, 0);
	
	}
	public int Find(int child)
	{   
		if(parents[child]==-1)
		{
			return child;
		}
		return  parents[child]=Find(parents[child]);
		}
   public	void Union(int a,int b)
	{
		int parentA=Find(a);
		int parentB=Find(b);
		if(parentA==parentB) return;
		if(rank[parentA]<rank[parentB])
		{
			parents[parentA]=b;
		}
		else if(rank[parentA]>rank[parentB])
		{
			parents[parentB]=a;
		}
		else
		{
			parents[parentB]=a;
			rank[parentB]++;
		}
	} 
   public int NoofCompounds()
   {
	   int count=0;
	  
	   for(int i=1;i<n;i++)
	   {
		if(parents[i]==-1) { count++;  }  
	   }
	return count;
   }
public void toMakeConnected() {
	// TODO Auto-generated method stub
	
	for(int i=1;i<n;i++)
	{
		if(parents[i]==-1)
		{
			for(int j=i+1;j<n;j++)
				if(parents[j]==-1)
				System.out.println(i+" "+j);
		}
	}
	
}
}
public class BuildingRoads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] values=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		UnionFind graph=new UnionFind(values[0]);
		while(values[1]-->0)
		{
			int[] readl=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph.Union(readl[0],readl[1]);
 		}
      System.out.println(graph.NoofCompounds()-1);
      graph.toMakeConnected();
 	}

}
/*6 -> 2 -> 33
 *  0 0 0 0 0 0 0
 *  {(1,2)
 *   (1,3)
 *   
 *   2 1
 *   1
 *   3 1
 *   1 2 
 *   7  5   3      2       1
 *   0  0   0      0       0      0
 *   1*5  2*4 3*3  4*2     5*1   6*0
 *   1*2  2*1  3*0
 *   10 4 3 2 1 
 *   10 10 10 10 10 10
 *   7 7  7   7   7  7  
 *   60
 *   
 *   
 *   
 *   
 *  }
 * 1-> 
 *  1*2 
 *  1
 *  
 *  1  1
 *  2  
 *  3  3
 *  4 
 *  5  5
 *  6
 * 
 *  
 *  
 *  
 */

