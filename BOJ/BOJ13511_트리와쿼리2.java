import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13511_트리와쿼리2 {
	static class point{
		int x;
		long w;
		
		point(){
			this.x = 0;
			this.w = 0;
		}
		
		point(int x, long weight){
			this.x = x;
			this.w = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int l = log(n);
		int[] mult = new int[18];
		int[] depth = new int[n+1];
		point[][] dp = new point[n+1][l+1];
		
		for (int i = 0; i <= n; i++) {
		    for (int j = 0; j <= l; j++) {
		        dp[i][j] = new point(); // 객체 초기화
		    }
		}
		
		// mult 값을 저장 
		int index = 1;
		for(int i = 0; i <= 17; i++) {
			mult[i] = index;
			index *= 2;
		}
		
		// 트리 저장용 arraylist
		List<int[]>[] al = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		
		// 트리 구성 
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			al[u].add(new int[] {v, w});
			al[v].add(new int[] {u, w});	
		}
		
		//dp에 부모 요소 반영  
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for(int[] x: al[now]) {
				int next = x[0];
				int w = x[1];
				if(!visited[next]) {
					q.add(next);
					depth[next] = depth[now]+1;
					dp[next][0].x = now;
					dp[next][0].w = w;
					visited[next] = true;
				}
			}
		}
		
		
		// 트리 dp 생성 
		for(int i = 1; i <= l; i++) {
			for(int j = 2; j <= n; j++) {
				dp[j][i].x = dp[dp[j][i-1].x][i-1].x;
				dp[j][i].w = dp[dp[j][i-1].x][i-1].w + dp[j][i-1].w;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int t = 0; t < m; t++) {
			long weight = 0, result = 0;
			int length = 0;
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int a = u;
			int v = Integer.parseInt(st.nextToken());
			int b = v;
			if(depth[a] < depth[b]) {
				int temp = a;
				a = b;
				b = temp;
			}
			int differ = depth[a] - depth[b];
			length += differ;
			while(depth[a] != depth[b]) {
				for(int i = l; i >= 0; i--) {
					if(mult[i] <= differ) {
						weight += dp[a][i].w;
						a = dp[a][i].x;
						differ -= mult[i];
					}
				}
			}
			
			while(a != b) {
				if(dp[a][0].x == dp[b][0].x) {
					weight += dp[a][0].w + dp[b][0].w;
					a = dp[a][0].x;
					b = dp[b][0].x;
					length += 2;
				}else {
					for(int i = l; i >= 0; i--) {
						if(dp[a][i].x != dp[b][i].x) {
							weight += dp[a][i].w + dp[b][i].w; 
							a = dp[a][i].x;
							b = dp[b][i].x;
							length += (mult[i])*2;
							break;
						}
					}
				}
			}
			
			if(e==1) {
				result = weight;
			}else {
				int k = Integer.parseInt(st.nextToken())-1;	
				differ = depth[u] - depth[v];
				int d1 = length - Math.abs(differ);
				int d2 = d1/2;
				int d3 = 0; 
				int d4 = 0;
				if(differ > 0) {
					d3 = d2 + differ;
					d4 = d2;
				}else {
					d3 = d2;
					d4 = d2 - differ;
				}
				
				if(k <= d3) {
					while(k > 0) {
						for(int i = l; i >= 0; i--) {
							if(mult[i] <= k) {
								u = dp[u][i].x;
								k -= mult[i];
							}
						}
					}
					result = u;
				}else {
					k = length - k;
					while(k > 0) {
						for(int i = l; i >= 0; i--) {
							if(mult[i] <= k) {
								v = dp[v][i].x;
								k -= mult[i];
							}
						}
					}
					result = v;
				}
			}

			sb.append(result +"\n");
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
