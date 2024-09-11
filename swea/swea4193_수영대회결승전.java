package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea4193_수영대회결승전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] map;
		int[][] dist;
		int[] r = {1, -1, 0, 0};
		int[] c = {0, 0, 1, -1};
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int result = -1;
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			dist = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			map[x1][y1] = 3;
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {x, y});
			dist[x][y] = 0;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x2 = now[0];
				int y2 = now[1];
				for(int i = 0; i < 4; i++) {
					int xr = x2 + r[i];
					int yc = y2 + c[i];
					if(xr < n && xr > -1 && yc < n && yc > -1) {
						if(map[xr][yc]==0) {
							int a = dist[x2][y2] + 1;
							if(dist[xr][yc] > a) {
								dist[xr][yc] = a;
								q.add(new int[] {xr, yc});
							}
						}else if(map[xr][yc]==3) {
							if(result == -1) {
								result = dist[x2][y2] + 1;	
							}else if(result > dist[x2][y2] + 1) {
								result = dist[x2][y2] + 1;
							}
						}else if(map[xr][yc]==2) {
							int temp = (dist[x2][y2]+1)%3;
							int temp2 = (dist[x2][y2]+1)/3;
							int a = temp2*3;
							if(temp!=0) a += 3;
							if(dist[xr][yc] > a) {
								dist[xr][yc] = a;
								q.add(new int[] {xr, yc});
							}
						}
					}
				}
			}
			if(x == x1 && y == y1) result = 0;
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
