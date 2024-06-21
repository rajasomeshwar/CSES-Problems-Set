import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class   AccurateLee {
	public static void main(String[] arg) throws IOException
	{
		 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		 int test=Integer.parseInt(bf.readLine());
		 StringBuilder stn=new StringBuilder();
		 while(test-->0)
		 {
			 int n=Integer.parseInt(bf.readLine());
			 String s=bf.readLine();
			 StringBuilder stn1=new StringBuilder();
			 int last=s.length()-1;
			
			 while(last>-1 && s.charAt(last)=='1')
			 {
				 stn1.insert(0, '1');
				 last--;
			 }
			 while(last>-1)
			 {
				 if(s.charAt(last)=='0')
					  stn1.insert(0, '0');
				 last--;
			 }
			 while(stn1.length()>1 && stn1.charAt(stn1.length()-1)=='0')
				  stn1.deleteCharAt(stn1.length()-1);
			 stn.append(stn1+"\n");
		 }
		 System.out.println(stn);
	}
	private static int countBit(int val)
	{
		int count=0;
		for(int i=31;i>-1;i--)
			 if((val&(1<<i))!=0)
				 return i;
		return count;
	}
}
