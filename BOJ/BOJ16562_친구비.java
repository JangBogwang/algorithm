import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16562_친구비{
	static int[] cost, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		cost = new int[n+1];
		parent = new int[n+1];
		int result = 0;
	
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}	
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);	
		}
		
		for(int i = 1; i <= n; i++) 
			if(parent[i] == i) result += cost[i];
		
		if(result > k) System.out.print("Oh no");
		else System.out.print(result);
	}

	static void union(int x, int y) {
		int nX = find(x);
		int nY = find(y);
		
		if(nX != nY) {
			if(cost[nX] < cost[nY]) parent[nY] = nX;
			else parent[nX] = nY;
		}
	}
	
	static int find(int now) {
		if(parent[now]!=now) return parent[now] = find(parent[now]);
		else return now;
	}
}
