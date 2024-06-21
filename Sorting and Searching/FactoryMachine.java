import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FactoryMachine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         int value[] =Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	     long[] MachineTimes=Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
	     Arrays.sort(MachineTimes);
	    // System.out.println(Arrays.toString(MachineTimes));
	     long left=1,right=MachineTimes[0]*value[1];
	    		 while(left<=right)
	    		 {
	    			 long mid=(left+right)/2;
	    			 long machines=NoofMachinefactors(mid,MachineTimes);
	    			 
	    			 if(machines<value[1])
	    			 {
	    				 left=mid+1;
	    			 }
	    			 else
	    				 right=mid-1;
	    			// System.out.println(mid+" "+machines);
	    		 }
	     System.out.println(left);
	}

	private static long NoofMachinefactors(long mid, long[] machineTimes) {
		// TODO Auto-generated method stub
         long machines=0;
		for(int i=0;i<machineTimes.length;i++)
			 if(mid>=machineTimes[i])
			 {
				 machines+=(mid/machineTimes[i]);
				// System.out.println(" " +mid/machineTimes[i]);
			 }
			 else
				  return machines;
		return machines;
		
	}

}
