import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class FerrisWheel {
	public static void main(String[] arg)
	{
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		long x=scan.nextLong();
		long[] arr=new long[t];
		while(t-->0)
			 arr[t]=scan.nextLong();
		int left=0,right=arr.length-1;
		int count=0;
		Arrays.sort(arr);
		while(left<=right)
		{
			if(arr[left]+arr[right]<=x)
			{
				left++;
				
			}
			count++;
			right--;
		}
		System.out.println(count);
	}

/*
 * Timelimit excced nlogn 
 * 
 * Accepted 
 * Use two pointer
 * i j 
 * Must be sort
 * i-> start indx 
 * j-> end indx
 * move j ever time if i+j<x then i+1 is incr
 * 
 * 	public static void main(String[] args) {
 
		// TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
   int t=scan.nextInt();
   long x=scan.nextLong();
   long [] arr=new long[t];
   int i=0;
   TreeMap<Long,Integer> map=new TreeMap<>();
   while(t-->0)
   {
	   long temp=scan.nextLong();
	   arr[i++]=temp;
	  map.put(temp,1+map.getOrDefault(temp, 0));
   }
   int maxCount=0;
 //  System.out.println(map);
  while(!map.isEmpty())
   {
	 long v=map.ceilingKey(-1L);
	   if(map.containsKey(v)) {
		   maxCount++;
	   var nearFloor=map.floorKey(x-v);
	//  System.out.print(map+"  "+nearFloor+"  ");
	   if(nearFloor==null)
	   {
		   
		   if(map.get(v)>1)
				  map.put(v, map.get(v)-1);
			  else
				  map.remove(v);
		   continue;
	   }
	  if(map.get(v)>1)
		  map.put(v, map.get(v)-1);
	  else
		  map.remove(v);
	  if(map.containsKey(nearFloor)&& map.get(nearFloor)>1)
		   map.put(nearFloor, map.get(nearFloor)-1);
	  else
		   map.remove(nearFloor);
	//  System.out.println(map);
	   }
	   
	  
   }
   System.out.println(maxCount);
	}
	*/

}
