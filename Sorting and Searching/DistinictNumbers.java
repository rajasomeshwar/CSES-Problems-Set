import java.util.HashSet;
import java.util.Scanner;
public class DistinitSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		HashSet<Integer> set=new HashSet<>(t);
		while(t-->0)
			 set.add(scan.nextInt());
		System.out.println(set.size());

	}

}
