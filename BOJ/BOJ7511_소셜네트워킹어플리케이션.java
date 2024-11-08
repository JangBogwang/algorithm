import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7511_소셜네트워킹어플리케이션 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T;t++) {
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			
			parent = new int[n];
			
			for(int i = 0; i < n; i++) parent[i] = i;
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			int m = Integer.parseInt(br.readLine());
			sb.append("Scenario ").append(t).append(":\n");
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a)==find(b))sb.append("1\n");
				else sb.append("0\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	static int find(int a) {
		if(parent[a]!=a) return parent[a] = find(parent[a]);
		else return a;
	}
	
	static void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		
		if(fx!=fy) {
			if(fx > fy) parent[fy] = fx;
			else parent[fx] = fy;
		}
	}
}
