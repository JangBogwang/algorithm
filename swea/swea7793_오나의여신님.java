package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea7793_오나의여신님 {
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			Queue<int[]> q1 = new LinkedList<>();
			Queue<int[]> q2 = new LinkedList<>();
			Queue<int[]> q3 = new LinkedList<>();
			int[] goal = new int[2];
			char[][] map = new char[n][m];
			int[][] distance = new int[n][m];
			
			for(int i = 0; i < n; i++)
				Arrays.fill(distance[i], 100000);
			
			for(int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < m; j++) {
					if(map[i][j]=='S') {
						map[i][j] = '.';
						distance[i][j] = 0;
						q1.add(new int[] {i, j});
					}else if(map[i][j]=='*') 
						q2.add(new int[] {i, j});
					else if(map[i][j]=='D')
						goal = new int[] {i, j};
				}
			}
			
			
			while(!q1.isEmpty()) {
				while(!q2.isEmpty()) {
					int[] now = q2.poll();
					int x = now[0];
					int y = now[1];
					for(int i = 0; i < 4; i++) {
						int xr = x + r[i];
						int yc = y + c[i];
						if(check(xr,yc)&&map[xr][yc]=='.') {
							map[xr][yc] = '*';
							q3.add(new int[] {xr,yc});
						}
					}
				}
				
				while(!q3.isEmpty()) {
					q2.add(q3.poll());
				}
				
				while(!q1.isEmpty()) {
					int[] now = q1.poll();
					int x = now[0];
					int y = now[1];
					for(int i = 0; i < 4; i++) {
						int xr = x + r[i];
						int yc = y + c[i];
						if(check(xr,yc)&&(map[xr][yc]=='.'||map[xr][yc]=='D')&&distance[xr][yc] > distance[x][y]+1){
							distance[xr][yc] = distance[x][y]+1;
							q3.add(new int[] {xr,yc});
						}
					}
				}
				
				while(!q3.isEmpty()) {
					q1.add(q3.poll());
				}
			}
			
			sb.append("#"+t+" ");
			if(distance[goal[0]][goal[1]]==100000) 
				sb.append("GAME OVER\n");
			else sb.append(distance[goal[0]][goal[1]]+"\n");
		}
		System.out.print(sb);
	}
	
	static boolean check(int x, int y) {
		if(x < n && x > -1 && y < m && y > -1) 
			return true;
		else return false;
	}
}
