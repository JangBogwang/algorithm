package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea7465_창용마을무리의개수 {
	static int count;
	static int n;
	static int m;
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			al = new ArrayList[n+1];
			for(int i = 0; i <= n; i++) al[i] = new ArrayList<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				al[s].add(e);
				al[e].add(s);
			}
			
			visited = new boolean[n+1];
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i]) {
					count++;
					bfs(i);
				}
			}
			
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		visited[now] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int b: al[a]) {
				if(!visited[b]) {
					visited[b] = true;
					q.add(b);
				}
			}
		}
	}
}
