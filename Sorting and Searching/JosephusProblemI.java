import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusProblemI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(bf.readLine());
		StringBuilder strn=new StringBuilder();
		//IntStream.range(1, value).filter(e -> e%2==0?true:false).map(Object::toString).collect(Collectors.joining(" "));
		int i=2;
		while(i<=value) {
			strn.append(i+" ");
			i+=2;
		}
		
		i=1;
		while(i<=value)
		{
			strn.append(i+" ");
			i+=2;
		}
		System.out.println(strn);

	}

};