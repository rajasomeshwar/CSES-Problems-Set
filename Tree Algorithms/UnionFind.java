import java.util.Arrays;

public class UnionFind
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