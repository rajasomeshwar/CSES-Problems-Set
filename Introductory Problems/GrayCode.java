import java.util.Scanner;

public class GrayCode {
static StringBuilder str;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scan = new Scanner(System.in);
        short value=scan.nextShort();
        str=new StringBuilder();
        GenerateGray(value,new char[value]);
        System.out.println(str);
	}

	private static void GenerateGray(int i,char[] arr) {
		// TODO Auto-generated method stub
		if(i==0)
		{
			str.append(new String(arr)+"\n");
			return;
		}
		arr[i-1]='0';
		GenerateGray(i-1,arr);
		arr[i-1]='1';
		GenerateGray(i-1,arr);
		
	}

}
