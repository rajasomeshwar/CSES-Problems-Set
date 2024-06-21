import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.PriorityQueue;


public class SlidingMedian {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int[] value=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>((a,b)->a>b?-1:1);
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>((a,b)->a>b?1:-1);
		StringBuilder stn=new StringBuilder();
		int left=0;
		minHeap.offer(arr[0]);
		for(int i=0;i<arr.length;i++)
		{  
			if(i==0);
			else	if(!minHeap.isEmpty() && minHeap.peek()<=arr[i] )
			minHeap.offer(arr[i]);
		else
			 maxHeap.offer(arr[i]);
	//	System.out.println("min "+minHeap+" max "+maxHeap);
			if(Math.abs(minHeap.size()-maxHeap.size())>1)
			{
				rearrange(minHeap,maxHeap);
			}
			if(i+1==value[1])
			{
				//System.out.println(" aj "+i);
				if(value[1]%2==1)
					stn.append(((minHeap.size()>maxHeap.size())?minHeap.peek():maxHeap.peek())+" ");
					else
						stn.append((Math.min(minHeap.peek(),maxHeap.peek()))+" ");
			}
			if(i>=value[1])
			{
			//	System.out.println(i+" ");
				if(minHeap.contains(arr[left]))
				{
					minHeap.remove(arr[left]);
					
				}
				else
				{
					maxHeap.remove(arr[left]);
				}
				if(Math.abs(minHeap.size()-maxHeap.size())>1)
				{
					rearrange(minHeap,maxHeap);
				}
				left++;
				if(value[1]%2==1)
				stn.append(((minHeap.size()>maxHeap.size())?minHeap.peek():maxHeap.peek())+" ");
				else
					stn.append((Math.min(minHeap.peek(),maxHeap.peek()))+" ");
				
				
			}
			//System.out.println("min "+minHeap+" max "+maxHeap);
		}
		System.out.println(stn);

	}

	private static void rearrange(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		// TODO Auto-generated method stub
		if(minHeap.size()<maxHeap.size())
		{
			minHeap.offer(maxHeap.poll());
		}
		else
		{
			maxHeap.offer(minHeap.poll());
		}
		
	}

	

}
