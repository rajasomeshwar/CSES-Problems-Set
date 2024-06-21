import java.util.Arrays;

public class segmentTree {
  int[] arr;
  int n;
  segmentTree(int n)
  {
	  this.n=n;
	  arr=new int[n-1+n];
  }
  private int build(int[] arr,int left,int right,int indx)
  {
	  if(left==right)
	  {
		  return this.arr[indx]=arr[left];
	  }
	 return this.arr[indx]=Math.min(build(arr,left,(left+right)/2,indx*2+1),build(arr,(left+right)/2+1,right,indx*2+2));
  }
  public void constructTree(int[] arr)
  {
	  build(arr,0,arr.length-1,0);
  }
  public void print()
  {
	  System.out.println(Arrays.toString(arr));
  }
public int min(int left, int right) {
	// TODO Auto-generated method stub
	return Findmin(left,right,0,n-1,0);
	
}
private int Findmin(int left, int right, int  L, int R,int indx) {
	// TODO Auto-generated method stub
	
	//partial overapp
	//System.out.println("St "+ L+" "+R+" "+left+" n "+right+ " "+arr[indx]);
	if(R<left || L>right)
		return Integer.MAX_VALUE;
	else if(left<=L && R<=right) return arr[indx];
	
		return Math.min(Findmin(left,right,L,(L+R)/2,indx*2+1), Findmin(left,right,(L+R)/2+1,R,indx*2+2));
	
	//no overlapping
	

}

}

