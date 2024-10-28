import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOj17352_여러분의다리가되어드리겠습니다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer>[] al = new ArrayList[n+1];
		boolean[] visit = new boolean[n+1];
		for(int i = 0; i <= n; i++)
			al[i] = new ArrayList<>();
		
		int s = 0, e = 0;
		for(int i = 0; i < n-2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al[a].add(b);
			al[b].add(a);
			
			s = a;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visit[s] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int x: al[now]) {
				if(!visit[x]) {
					visit[x] = true;
					q.add(x);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				e = i;
				break;
			}
		}
		if(s == 0) 
			s = 2;
		if(e < s) {
			int temp = s;
			s = e;
			e = temp;
		}
		
		System.out.print(s+" "+e);
		
	}
}
