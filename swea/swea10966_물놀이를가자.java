package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea10966_물놀이를가자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		char[] land;
		int[][] dist;
		int[] r = {-1, 1, 0, 0};
		int[] c = {0, 0, -1, 1};
		int result;
		Queue<int[]> q = new LinkedList<>();
		
		for(int t = 1; t <= T; t++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			dist = new int[n][m];
			for(int i = 0; i < n; i++) Arrays.fill(dist[i], 100000000);
			
			for(int i = 0; i < n; i++) {
				land = br.readLine().toCharArray();
				for(int j = 0; j < m; j++) {
					if(land[j] == 'W') {
						q.add(new int[] {i,j});
						dist[i][j] = 0;
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				for(int i = 0; i < 4; i++) {
					int xr = x + r[i];
					int yc = y + c[i];
					if(xr < n && xr > -1 && yc < m && yc > -1) {
						if(dist[xr][yc] > dist[x][y] + 1) {
							dist[xr][yc] = dist[x][y] + 1;
							q.add(new int[] {xr, yc});
						}
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					result += dist[i][j];
				}
			}

			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
