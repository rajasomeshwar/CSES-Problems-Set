

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class treeDiameter {
    
   public static void main(String[] arg) throws Exception 
     {
	   
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(bf.readLine());
        HashMap<Integer,List<Integer>> tree=new HashMap<>();
        int[] arr;
        for(int i=0;i<size-1;i++)
        {
         arr=Arrays.stream(bf.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
          List<Integer> list=tree.getOrDefault(arr[0],new ArrayList<>());
          list.add(arr[1]);
          tree.put(arr[0],list);
           list=tree.getOrDefault(arr[1],new ArrayList<>());
          list.add(arr[0]);
          tree.put(arr[1], list);
        }
        //System.out.println(tree);
        int count=-1;
        if(!tree.containsKey(1))
        {
         System.out.println(0);
         return;
        }
        int[] visited=new int[size+1];
        Arrays.fill(visited,-1);
         Queue<Integer> queue=new LinkedList<>();
         queue.add(1);
         visited[1]=1;
         int lastNode=0;
         while(!queue.isEmpty())
         {
           int s=queue.size();
           while(s-->0)
           {
        	   int vert=queue.poll();
        	   lastNode=vert;
        	   for(int adj : tree.get(vert))
                   if(visited[adj]==-1) 
                   {
                	   queue.add(adj);
                	   visited[adj]=1;
                   }
        		  
           }
         }
        
         queue.clear();
         queue.offer(lastNode);
         Arrays.fill(visited, -1);
         visited[lastNode]=1;
         while(!queue.isEmpty())
         {
        	 count++;
        	 int s=queue.size();
             while(s-->0)
             {
          	   int vert=queue.poll();
          	   lastNode=vert;
          	   for(int adj : tree.get(vert))
                     if(visited[adj]==-1) 
                     {
                  	   queue.add(adj);
                  	   visited[adj]=1;
                     }
          		  
             }
         }
         System.out.println(count);
         
         
 
    }
    
}


