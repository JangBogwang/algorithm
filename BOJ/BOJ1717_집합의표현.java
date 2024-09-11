package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 66296kb 시간: 424ms
public class BOJ1717_집합의표현 {
	static Edge[] edges; 
	
	static class Edge{
		int farher;
		
		Edge(int f){
			this.farher = f;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		edges = new Edge[n+1];
		for(int i = 0; i < n+1; i++)
			edges[i] = new Edge(i);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int a_set = find_root(a);
			int b_set = find_root(b);
			
			if(order == 1) {
				if(a_set == b_set) 
					sb.append("YES\n");
				else 
					sb.append("NO\n");
			}else if(order == 0 && a_set!=b_set) 
					union(a_set, b, b_set);
		}
		System.out.print(sb);
	}
	
	static int find_root(int a) {
		if(edges[a].farher!=a)
			return find_root(edges[a].farher);
		return a;
	}
	
	static void union(int a, int b, int b_set) {
		int now = b;
		while(now!=b_set) {
			int now2 = edges[now].farher;
			edges[now].farher = a;
			now = now2;
		}
		edges[b_set].farher = a;
	}
}
