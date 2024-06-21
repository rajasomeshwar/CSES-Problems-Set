
public class Testingclass {

	
		public static void main(String[] arg)
		{
			segmentTree tree=new segmentTree(8);
			tree.constructTree(new int[] {7, 6, 4 ,6 ,2 ,9 ,4 ,8});
			tree.print();
			for(int i=0;i<8;i++)
				for(int j=i;j<8;j++)
					System.out.println(i+" "+j+"  "+tree.min(i,j));
		}
	
}
