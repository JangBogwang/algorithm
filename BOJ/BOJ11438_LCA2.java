import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11438_LCA2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int l = log(n);
		int[][] dp = new int[n+1][l+1];
		int[] mult = new int[l+1];
		int[] depth = new int[n+1];
		
		int index = 1;
		for(int i = 0; i < l+1; i++) {
			mult[i] = index;
			index *= 2;
		}
		
		
		// dp 구성 
		List<Integer>[] al = new ArrayList[n+1];
		for(int i = 0; i <= n; i++)
			al[i] = new ArrayList<>();
		
		// 그래프 구성 
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			al[a].add(b);
			al[b].add(a);
		}
		
		// 부모 탐색
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int x: al[now]) {
				if(!visited[x]) {
					visited[x] = true;
					dp[x][0] = now;
					depth[x] = depth[now]+1;
					q.add(x);
				}
			}
		}
		
		// dp 구성 
		for(int i = 1; i < l+1; i++) {
			for(int j = 2; j <= n; j++) {
				dp[j][i] = dp[dp[j][i-1]][i-1];
			}
		}
		
		// 케이스 탐색 
		int m = Integer.parseInt(br.readLine());
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(depth[b] > depth[a]) {
				int temp = b;
				b = a;
				a = temp;
			}
			
			int differ = depth[a] - depth[b];
			
			while(differ > 0) {
				for(int i = l; i >= 0; i--) {
					if(differ >= mult[i]) {
						a = dp[a][i];
						differ -= mult[i];
					}
				}
			}
			
			while(a != b) {
				if(dp[a][0]==dp[b][0]) {
					a = dp[a][0];
					b = dp[b][0];
				}
				else {
					for(int i = l; i >= 0; i--) {
						if(dp[a][i] != dp[b][i]) {
							a = dp[a][i];
							b = dp[b][i];
							break;
						}
					}
				}
			}
			sb.append(a+"\n");
		}
		System.out.print(sb);
	}
	
	static int log(int n) {
		int count = 0;
		while(n > 1) {
			n /= 2;
			count++;
		}
		
		return count;
	}
}
