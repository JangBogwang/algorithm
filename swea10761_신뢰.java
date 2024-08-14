import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea10761_신뢰 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String[] ss = new String[n]; 
			Queue<Integer> b = new LinkedList<>(); 
			Queue<Integer> o = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				String s = st.nextToken();
				if(s.equals("B")) b.add(Integer.parseInt(st.nextToken()));
				if(s.equals("O")) o.add(Integer.parseInt(st.nextToken()));
				ss[i] = s;
			}
			
			int b1=1, o1=1;
			int b_now = 1, o_now =1;
			int sum = 0;
			if(!b.isEmpty()) {
				b_now = b.peek();
				b1 = b.poll()-1; 
			}
			if(!o.isEmpty()) {
				o_now = o.peek();
				o1 = o.poll()-1;
			}
			for(int i = 0; i < n; i++) {
				int x = 0;
				if(ss[i].equals("B")) {
					if(b1<=0) x = 1;
					else x = b1+1;
					
					if(!b.isEmpty()) {
						b1 = Math.abs(b.peek() - b_now);
						b_now = b.poll();
					}
					else b1 = 0;
					
					o1 -= x;
				}
				else if(ss[i].equals("O")) {
					if(o1<=0) x = 1;
					else x = o1+1;
					
					if(!o.isEmpty()) {
						o1 = Math.abs(o.peek() - o_now);
						o_now = o.poll();
					}
					else o1 = 0;
					
					b1 -= x;
				}
				sum+=x;
			}
			
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.print(sb);
	}
}
