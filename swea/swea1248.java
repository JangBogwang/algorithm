import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea1248 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for(int x = 1; x <= t; x++)
        {
           String[] str = br.readLine().split(" ");
           int n = Integer.parseInt(str[0]);
           int m = Integer.parseInt(str[1]);
           int a = Integer.parseInt(str[2]);
           int b = Integer.parseInt(str[3]);
           int[] route_a =new int[n];
           int[] route_b = new int[n];
           Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
           Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
           
           sb.append("#"+x+" ");
           
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int i = 0; i < m; i++) {
        	   int c = Integer.parseInt(st.nextToken());
        	   int d = Integer.parseInt(st.nextToken());
        	   map2.put(d, c); 
        	   if(map.containsKey(c)) {
        		   ArrayList<Integer> al = map.get(c);
        		   al.add(d);
        		   map.put(c, al);
        	   }
        	   else {
        		   ArrayList<Integer> al = new ArrayList<>();
        		   al.add(d);
        		   map.put(c,al);
        	   }
           }
           int index_a = search(map2,a, route_a, 0);
           int index_b = search(map2,b, route_b, 0);
           int last = 0;
           while(route_b[index_b]==route_a[index_a]) {
        	   last = route_b[index_b];
        	   index_a--;
        	   index_b--;
        	   if(index_a<0||index_b<0) break;
           }
           
           sb.append(last+" ");
           int count = 1;
           Queue<Integer> q = new LinkedList<>();
           q.add(last);
           while(q.size()!=0) {
        	   int e =  q.poll();
        	   if(map.get(e)!=null) {
            	   for(int f :map.get(e)) {
            		   q.add(f);
            		   count++;
            	   }
        	   }
           }
           sb.append(count+"\n");
           
        }
        System.out.print(sb);
    }
    
    static int search(Map<Integer, Integer> map, int next, int[] route, int index) {
    	if(map.containsKey(next)) {
        	route[index] = map.get(next);
        	return search(map, route[index], route, index+1);
    	}
    	return index-1;
    }
}
