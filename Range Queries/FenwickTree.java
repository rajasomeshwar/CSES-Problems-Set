package Pattern;

import java.util.Arrays;

public class FenwickTree {
   int[] fin;
   //1 based index
   FenwickTree(int n)
   {
	   fin=new int[n+1];
	   Arrays.fill(fin,0);
   }
   public void add(int indx,int val)
   {
	   for(;indx<fin.length;indx=indx+(indx&(-indx)))
	   {
		   fin[indx]+=val;
	   }
   }
   public long range(int l,int r)
   {
	   return get(r)-get(l-1);
   }
  public  long get(int indx) {
	// TODO Auto-generated method stub
	 
	  int count=0;
	  for(;indx>0;)
	  {
		  count+=(fin[indx]);
		  indx=indx-(indx&(-indx));  //2->10 01 0 
	  }
	  return count;
}
  public void range_add(int l,int r,int val)
  {
	  add(l,val);
	  add(r+1,-val);
  }
  public void build(int[] arr)
  {
	  for(int i=0;i<arr.length;++i)
		   add(i+1, arr[i]);
  }
}
