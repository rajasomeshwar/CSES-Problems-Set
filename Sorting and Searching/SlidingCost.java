import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingCost {
	static long minsum=0,maxsum=0;

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
		
		minsum+=arr[0];
		for(int i=0;i<arr.length;i++)
		{  
			if(i==0);
			else	if(!minHeap.isEmpty() && minHeap.peek()<=arr[i] ) {
               minsum+=arr[i];
				minHeap.offer(arr[i]);
			}
		else {
			maxsum+=arr[i];
			 maxHeap.offer(arr[i]);
		}
	//	System.out.println("min "+minHeap+" max "+maxHeap);
			if(Math.abs(minHeap.size()-maxHeap.size())>1)
			{
				rearrange(minHeap,maxHeap);
			}
			if(i+1==value[1])
			{
				int median=0;
				//System.out.println(" aj "+i);
			
				if(value[1]%2==1)
					median=((((minHeap.size()>maxHeap.size())?minHeap.peek():maxHeap.peek())));
					else
						median=Math.min(minHeap.peek(),maxHeap.peek());
				stn.append(Math.abs(Math.abs(minsum-maxsum)-median)+" ");
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
				int median=0;
				//System.out.println(" aj "+i);
			
				if(value[1]%2==1)
					median=((((minHeap.size()>maxHeap.size())?minHeap.peek():maxHeap.peek())));
					else
						median=Math.min(minHeap.peek(),maxHeap.peek());
				stn.append(Math.abs(Math.abs(minsum-maxsum)-median)+" ");
				
				
			}
			//System.out.println("min "+minHeap+" max "+maxHeap);
		}
		System.out.println(stn);

	}

	private static void rearrange(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		// TODO Auto-generated method stub
		if(minHeap.size()<maxHeap.size())
		{
			minsum+=maxHeap.peek();
			maxsum-=maxHeap.peek();
			minHeap.offer(maxHeap.poll());
		}
		else
		{
			minsum-=minHeap.peek();
			maxsum+=minHeap.peek();
			maxHeap.offer(minHeap.poll());
		}
		
	}


}
