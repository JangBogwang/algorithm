package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13308_주유소 {
	
	static ArrayList<long[]>[] al;
	static Queue<long[]> q;
	static long[] costs;
	static long[]dp;
	static long[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		costs = new long[n+1];
		dp = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) 
			costs[i] = Long.parseLong(st.nextToken());
		costs[n] = 0;
		
		al = new ArrayList[n+1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[1] = 0;
	

		for(int i = 0; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			al[x].add(new long[] {y, w});
			al[y].add(new long[] {x, w});
		}
		
		q = new LinkedList<>();
		
		q.add(new long[] {1, costs[1]});
		while(!q.isEmpty()) {
			long[] now = q.poll();
			visited = new long[n+1];
			Arrays.fill(visited, Long.MAX_VALUE);
			int x = (int)now[0];
			visited[x] = 0;
			search(now, dp[x],0);
		}
		
		System.out.print(dp[n]);
	}
	
	static void search(long[] now, long prev, long sum) {
		int x = (int)now[0];
		long cost = now[1];
		for(long[] temp: al[x]) {
			int x2 = (int)temp[0];
			long w = temp[1];
			if(visited[x2] > sum+w){
				visited[x2] = sum+w;
				if(costs[x2] >= cost) {
					search(new long[] {x2, cost}, prev, sum+w);
				}else if(costs[x2] < cost&&dp[x2] > prev+(sum+w)*cost) {
					dp[x2] = prev+(sum+w)*cost;
					q.add(new long[] {x2, costs[x2]});
				}	
			}
		}
	}
}
