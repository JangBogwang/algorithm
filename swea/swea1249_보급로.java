package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1249_보급로 {
	static int[] r = {-1, 1, 0, 0};
	static int[] c = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] map;
		int n;
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			int[][] distance = new int[n][n];
			for(int i = 0; i < n; i++) 
				Arrays.fill(distance[i], 100000);
			
			
			for(int i = 0; i < n; i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j = 0; j < n; j++) {
					map[i][j] = temp[j]-'0';
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {0,0});
			distance[0][0] = 0;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				for(int i = 0; i < 4; i++) {
					int xr = x+r[i];
					int yc = y+c[i];
					if(xr < n && xr > -1 && yc < n && yc > -1) {
						if(distance[xr][yc] > distance[x][y]+map[xr][yc]){
							distance[xr][yc] = distance[x][y]+map[xr][yc];
							q.add(new int[] {xr, yc});
						}
					}
				}
			}
			
			sb.append("#"+t+" "+distance[n-1][n-1]+"\n");
		}
		System.out.print(sb);
	}
}
