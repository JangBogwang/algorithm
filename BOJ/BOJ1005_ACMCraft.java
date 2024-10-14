package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005_ACMCraft {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			// 입력  
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] time = new int[n+1];
			int[] count = new int[n+1];
			List<Integer>[] ll = new ArrayList[n+1]; 
			for(int i = 0; i < n+1; i++)
				ll[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++)
				time[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ll[a].add(b);
				count[b]++;
			}
			
			int goal = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			int min_time = Integer.MAX_VALUE;
			for(int i = 1; i <= n; i++) {
				if(count[i]==0) {
					q.add(i);
					if(time[i] < min_time)
					 	min_time = time[i];
				}
			}
			
			int result = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				result += min_time;
				int min_time2 = Integer.MAX_VALUE;;
				for(int i = 0; i < size; i++) {
					int now = q.poll();
					time[now] -= min_time;
					if(time[now]==0) {
						if(now == goal) {
							q.clear();
							break;
						}
						for(int x: ll[now]) {
							count[x]--;
							if(count[x]==0) {
								q.add(x);
								if(time[x] < min_time2)
									min_time2 = time[x];
							}
						}
					}else {
						q.add(now);
						if(time[now] < min_time2)
							min_time2 = time[now];
					}
					
				}
				min_time = min_time2;
			}
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
