package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14567_선수과목 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer>[] al = new ArrayList[n+1];
		int[] count = new int[n+1];
		int[] result = new int[n+1];
		for(int i = 0; i <= n; i++)
			al[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			count[b]++;
			al[a].add(b);
		}
		
		for(int i = 1; i <= n; i++) {
			if(count[i]==0) 
				q.add(i);
		}
		int time = 0;
		while(!q.isEmpty()) {
			time++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int temp = q.poll();
				result[temp] = time;
				for(int x: al[temp]) {
					count[x]--;
					if(count[x]==0) {
						q.add(x);
					}
				}
				
			}
		}
		
		for(int i = 1; i <= n; i++)
			sb.append(result[i]+" ");
		System.out.print(sb);
	}
}
