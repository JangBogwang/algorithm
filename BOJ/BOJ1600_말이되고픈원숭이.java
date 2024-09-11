package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {
	static int[] r = {-1, 1, 0, 0};
	static int[] c = {0, 0, -1, 1};
	static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hc = {-1, 1, -2, 2, 2, -2, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][][] distance = new int[n][m][k+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Arrays.fill(distance[i][j], 1000000);
			}
		}
		
		
		for(int i = 0; i < k+1; i++)
			distance[0][0][i] = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int i = 0; i < 4; i++) {
				int xr = x + r[i];
				int yc = y + c[i];
				if(xr < n && xr > -1 && yc < m && yc > -1) {
					for(int j = 0; j < k+1; j++) {
						if(map[xr][yc]==0&&distance[xr][yc][j] > distance[x][y][j] + 1) {
							distance[xr][yc][j] = distance[x][y][j] + 1;
							q.add(new int[] {xr, yc});
						}
					}
				}
			}
			
			for(int i = 0; i < 8; i++) {
				int xr = x + hr[i];
				int yc = y + hc[i];
				if(xr < n && xr > -1 && yc < m && yc > -1) {
					for(int j = 0; j < k; j++) {
						if(map[xr][yc]==0&&distance[xr][yc][j+1] > distance[x][y][j] + 1) {
							distance[xr][yc][j+1] = distance[x][y][j] + 1;
							q.add(new int[] {xr, yc});
						}
					}
				}
			}
		}
		
		int min = 1000000;
		for(int i = 0; i < k+1; i++) 
			if(min > distance[n-1][m-1][i])
				min = distance[n-1][m-1][i]; 
		
		if(min == 1000000) min = -1;
		System.out.print(min);
	}
}
