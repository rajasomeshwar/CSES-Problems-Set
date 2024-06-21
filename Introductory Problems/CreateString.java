import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CreateString {
  static LinkedHashSet<String> str;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		String str1=scan.next();
		str=new LinkedHashSet<>();
 
	  char[] strinCharArray=str1.toCharArray();
	  Arrays.sort(strinCharArray);
	  int[] visited=new int[str1.length()];
	  Arrays.fill(visited, -1);
        Generate(strinCharArray,new char[str1.length()],0,visited);
	System.out.println(str.size());
	for(String i : str )
	System.out.println(i);
	}

	private static void Generate(char[] str, char[] cs, int i, int[] visited) {
		// TODO Auto-generated method stub
		if(i==cs.length)
		{
			//System.out.println(new String(cs)+" \n nex ");
			CreateString.str.add(new String(cs));
			return;
		}
		for(int i1=0;i1<str.length;i1++)
		{
			if(visited[i1]==-1)
			{
				visited[i1]=1;
				cs[i]=str[i1];
				Generate(str,cs,i+1,visited);
				visited[i1]=-1;
			}
			
		}
	}

}
