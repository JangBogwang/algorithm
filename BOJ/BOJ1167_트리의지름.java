package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1167_트리의지름 {
	static ArrayList<int[]>[] node;
	static boolean[] visited;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		node = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i <= n; i++)
			node[i] = new ArrayList<>();
		
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next!=-1) {
					int d = Integer.parseInt(st.nextToken());
					node[v].add(new int[] {next, d});
				}else break;
			}
		}
		result = 0;
		visited[1] = true;
		search(1);
		
		System.out.print(result);
	}
	
	static long search(int now) {
		int size = node[now].size();
		long max = 0;
		if(size!=0) {
			Deque<Long> dq = new ArrayDeque<>();
			dq.add((long)0);
			dq.add((long)0);
			for(int[] next: node[now]) {
				long temp;
				if(!visited[next[0]]) {
					visited[next[0]] = true;
					temp = next[1]+search(next[0]);
					if(dq.peekFirst() <= temp) {
						dq.addFirst(temp);
						dq.pollLast();
					}else if(dq.peekLast() < temp) {
						dq.pollLast();
						dq.addLast(temp);
					}
				}
			}
			max = dq.peekFirst();
			long t = dq.peekLast();
			if(result < max + t) {
				result = max + t;
			}
			
		}
		return max;
	}
}
