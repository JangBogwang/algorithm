package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		int n  = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] count = new int[n+1];
		List<Integer>[] ll = new ArrayList[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < n+1; i++) 
			ll[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ll[a].add(b);
			count[b]++;
		}
		
		for(int i = 1; i <= n; i++) {
			if(count[i]==0)
				q.add(i);
		}
		
		int index = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int now = q.poll();
				sb.append(now+" ");
				for(int next: ll[now]) {
					count[next]--;
					if(count[next]==0) {
						q.add(next);
					}
				}
			}
		}
		System.out.print(sb);	
	}

}
