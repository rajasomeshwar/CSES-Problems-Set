package Strings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class FindingBorders {
	static long p[],prefix[];
	static long mod=1_0000_0000_7;;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String stn=bf.readLine();
		HashSet<Long> set=new HashSet<>(stn.length()+1);
	
		p=new long[stn.length()+1];
		p[0]=1;
	//	long mod=1_0000_0000_7;
		for(int i=1;i<stn.length()+1;i++)
			 p[i]=(53L%mod*p[i-1]%mod)%mod;
		long hash=0;
	   prefix=new long[stn.length()+1];
		for(int i=0;i<stn.length();i++)
		{
			int val=stn.charAt(i)-'a'+1;
			hash=(hash%mod+(val*p[i]%mod)%mod)%mod;
			//System.out.print(hash+" ");
			prefix[i+1]=hash%mod;
		}
		System.out.println(Arrays.toString(prefix));
		hash=0;
		for(int i=1;i<stn.length()+1;i++)
		{
			System.out.println(get(0,i)+" "+get(stn.length()-i,stn.length()));
			if(get(0,i)==get(stn.length()-i,stn.length()))
				System.out.print(i+" ");
		}
		
	}

static long get(int s, int e) {
	return prefix[e] -(mod+ prefix[s] * prefix[e - s])%mod;
}


}
