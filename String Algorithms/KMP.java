package Strings;

import java.util.Arrays;

public class KMP {
  private String string,pattern;
  public int[] lps;//long preffix suffix
  public KMP()
   {
	   super();
   }
   public KMP(String string, String pattern) {
	   super();
	   this.string = string;
	   this.pattern = pattern;
   }
		public String getString() {
			return string;
		}
		public void setString(String string) {
			this.string = string;
		}
		public String getPattern() {
			return pattern;
		}
		public void setPattern(String pattern) {
			this.pattern = pattern;
		}
		   
		@Override
		public String toString() {
			return "KMP [string=" + string + ", pattern=" + pattern + "]";
		}
		public int SearchsubString()
		{
			int count=0;
			
			//System.out.println(Arrays.toString(Preprocess(pattern)));
			Preprocess(pattern);
			int j=0;
		   for(int i=0;i<string.length();i++)
		   {
			   if(pattern.charAt(j)==string.charAt(i))
				   j++;
			   else
			   {
				   if(j-1!=0)
					   j=lps[j-1];
			   }
			   if(j==pattern.length()) {j=lps[j-1];count++;}
		   }
			return count;
			
		}
		public int[] Preprocess(String pattern2) {
			// TODO Auto-generated method stub
			lps=new int[pattern.length()];
			Arrays.fill(lps, 0);
			int j=0;
			for(int i=1;i<pattern.length();i++)
			{
				j=lps[i-1];
				while(j!=0 && pattern.charAt(i)!=pattern.charAt(j))
				{
					j=lps[j-1];
				}
					
					if(pattern.charAt(i)==pattern.charAt(j)) {
						j++;
					}
					lps[i]=j;
					
				
			}
			return lps;
			
		}
		 
}
