import java.util.Scanner;

public class PalindromeReorder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
	  String str=scan.nextLine();
	  int[] hashArray=new int[26];
	  for(int i=0;i<str.length();i++)
		   hashArray[str.charAt(i)-'A']++;
	  if(isItMake(hashArray))
	  {
		  char middle = 'A';
		char[] palindrome = new char[str.length()];
		int left=0,right=str.length()-1;
		int i=0;
		while(i<26)
		{
	
				while(hashArray[i]>1)
				{
					palindrome[right--]=palindrome[left++]=(char)(i+'A');
					hashArray[i]-=2;
				}
				
				if(hashArray[i]==1)
					middle=(char)(i+'A');
			i++;
		}
		if(palindrome.length%2==1)
		palindrome[left]=middle;
		System.out.println(new String(palindrome));
	  }
	  else
		  System.out.println("NO SOLUTION");
	}

	private static boolean isItMake(int[] hashArray) {
		// TODO Auto-generated method stub
	  boolean b=true;
	  
	  for(int i: hashArray)
		   if(i%2==1)
			   if(b) {
				    b=false;
			   }
			   else {
				    return false;
			   }
		return true;
	}

}
