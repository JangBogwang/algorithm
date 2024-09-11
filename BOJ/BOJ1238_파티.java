package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1238_파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] al = new ArrayList[n+1];
		int[][] dist = new int[n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			Arrays.fill(dist[i], 10000000);
			al[i] = new ArrayList<>();
			dist[i][i] = 0;
		}
		
		// 각 경로 저장 
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			dist[x1][y1] = d1;
			al[x1].add(y1);
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		int max = 0;
		for(int i = 1; i <= n; i++ ) {
			if(dist[x][i]+dist[i][x] > max) {
				max = dist[x][i]+dist[i][x];
			}
		}
		
		System.out.print(max);
		
	}
}
