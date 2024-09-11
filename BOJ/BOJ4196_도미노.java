package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4196_도미노 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T  = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] parent = new int[n+1];
			int[] decendent = new int[n+1];
			boolean[] visited = new boolean[n+1];
			ArrayList<Integer>[] al = new ArrayList[n+1];
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i <= n; i++)
				al[i] = new ArrayList<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b]++;
				decendent[a]++;
				al[a].add(b);
			}
			
			int count = 0;
			
			// 시작점이 0인 것 싹 다 지운다. 
			for(int i = 1; i <= n; i++) {
				if(!visited[i]&&parent[i]==0) {
					count++;
					q.add(i);
					visited[i] = true;
					while(!q.isEmpty()) {
						int now = q.poll();
						for(int next: al[now]) {
							if(!visited[next]) {
								visited[next] = true;
								q.add(next);
							}
						}
					}
				}
			}
			
			//자식이 2개 이상인 것들 지우기
			for(int i = 1; i <= n; i++) {
				if(!visited[i]&&decendent[i]>1) {
					count++;
					q.add(i);
					visited[i] = true;
					while(!q.isEmpty()) {
						int now = q.poll();
						for(int next: al[now]) {
							if(!visited[next]) {
								visited[next] = true;
								q.add(next);
							}
						}
					}
				}
			}
			// 루프 지우기 
			for(int i = 1; i <= n; i++) {
				if(!visited[i]&&decendent[i]==1) {
					count++;
					q.add(i);
					visited[i] = true;
					while(!q.isEmpty()) {
						int now = q.poll();
						for(int next: al[now]) {
							if(!visited[next]) {
								visited[next] = true;
								q.add(next);
							}
						}
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
