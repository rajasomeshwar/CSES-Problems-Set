package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingPeriods {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String stn=bf.readLine();
		int[] prefix=new int[stn.length()+1];
		Arrays.fill(prefix, 0);
		int j=0;
		for(int i=1;i<stn.length();i++)
		{
			j=prefix[i-1];
			while(j!=0 && stn.charAt(i)!=stn.charAt(j))
			{
				j=prefix[j-1];
			}
			if(stn.charAt(i)==stn.charAt(j))
			{
				
				j++;
			}
			prefix[i]=j;
			if(prefix[i]!=0)
				System.out.print(i+" ");
		}

	}

}
