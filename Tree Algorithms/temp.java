import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Scanner;
public class temp
{

     public static void main(String[] arg)
     {
    	 Scanner scan =new Scanner(System.in);
    	 String str=scan.next();
    	 int even=0,odd=0;
    	 int count=1;
    	 for(int i=str.length()-1;i>-1;i--,count++)
    		  if(count%2==0)
    			   even+=(str.charAt(i)-'0');
    		  else
    			  odd+=(str.charAt(i)-'0');
    	 System.out.println(odd+"\n"+even);
    	 
     }
}