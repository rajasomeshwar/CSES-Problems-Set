import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
class co
{
	int inx;
	char ch;
	co(char ch,int inx)
	{
		this.ch=ch;
		this.inx=inx;
	}
}
class No
{
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getIndx() {
		return indx;
	}
	public void setIndx(int indx) {
		this.indx = indx;
	}
	Long no;
	int indx;
	No(Long no,int indx)
	{
		this.no=no;
		this.indx=indx;
	}
	
}
public class NomoreSymbols {
  private static HashMap<String,Character> map;
  private static HashMap<String,Character> map2;
  private static void compute()
  {
	  map=new HashMap<>();
	  map2=new HashMap<>();
	  map2.put("add", '+');
	  map2.put("div", '/');
	  map.put("one", '1');
	  map.put("two", '2');
	  map.put("three",'3');
	  map.put("four", '4');
	  map.put("five", '5');
	  map.put("six", '6');
	  map.put("seven", '7');
	  map.put("eight", '8');
	  map.put("nine", '9');
	  map.put("zero", '0');
	  map2.put("sub", '-');
	  map2.put("mul", '*');
	  map2.put("rem",'%');
	  map2.put("pow", '^');
	 
  }
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String[] expr=bf.readLine().replaceAll("\\s+"," ").split(" ");
		compute();
		
		System.out.println(solver((expr)));
	}
	private static String solver(String[] expr) {
		// TODO Auto-generated method stub
		LinkedList<co> operand=new LinkedList<>();
		LinkedList<No> operators=new LinkedList<>();
		for(int i=0;i<expr.length;i++)
		{
			String temp=expr[i];
			if(map2.containsKey(temp))
			{
				
				operand.add(new co(map2.get(temp),i));
			}
			else
			{String s=IsNumber(temp);
			 if(s!=null)
			{
			//	 System.out.println(s);
				operators.add(new No(Long.parseLong(s),i));
				if(operators.size()>=2 && IsNumber(expr[i-1])!=null) 
				{
					if(operand.size()>0)
					{
					co ch=operand.removeLast();
					
						No a=operators.removeLast();
						No b=operators.removeLast();
						Long ans=Perform(ch.ch,a.no,b.no);
						
						if(ans==null)
						{
							return "expression is not complete or invalid";
						}
						
						operators.add(new No(ans,Math.min(a.indx, b.indx)));
					}
					else
					{
						return "expression is not complete or invalid";
					}
				}
			}
			else
			{
				return "expression evaluation stopped invalid words present";
			}
			}
		//	System.out.println(operators);
		}
		while(!operand.isEmpty())
		{
			if(operators.size()>=2)
			{
				co ch=operand.removeLast();
				No a=operators.removeLast();
				No b=operators.removeLast();
				Long ans=null;
				if(Math.min(a.indx, b.indx)>ch.inx) {
				 ans=Perform(ch.ch,a.no,b.no);
				}
				
				
				
				if(ans==null)
				{
					return "expression is not complete or invalid";
				}
				
				operators.add(new No(ans,Math.min(a.indx, b.indx)));
			}
			else
			{
				return "expression is not complete or invalid";
			}
		}
		return operators.size()!=1?"expression is not complete or invalid":(""+operators.remove().no);
		
	}

	private static Long Perform(char ch, Long a, Long b) {
		// TODO Auto-generated method stub
		if(ch=='+')
			 return a+b;
		if(ch=='-') return b-a;
		if(ch=='*') return a*b;
		if(ch=='/') { if(a==0) return null;  return b/a;}
		if(ch=='%') {if(a==0) return null; return b%a;}
		if(ch=='^') return (long)Math.pow(b,a);
		return 0L;
	}

	private static String IsNumber(String temp) {
		// TODO Auto-generated method stub
		if(temp.charAt(temp.length()-1)=='c') return null;
		String[] number=temp.split("c");
		StringBuilder stn=new StringBuilder();
		for(String temp1 : number)
		{
			if(map.containsKey(temp1))
			{
				stn.append(map.get(temp1));
			}
			else
			{
				return null;
			}
		}
		
		return stn.toString();
	}

}
