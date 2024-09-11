package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea4192_수영대회 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] r = {1, -1, 0, 0};
		int[] c = {0, 0, 1, -1};
		
		for(int t = 1; t <= T; t++) {
			int result = -1;
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 0) a[i][j] = temp;
					else a[i][j] = -1;
				}
			}
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			a[x1][y1] = -2;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {x, y});
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x2 = now[0];
				int y2 = now[1];
				for(int i = 0; i < 4; i++) {
					int xr = x2 + r[i];
					int yc = y2 + c[i];
					if(xr < n && xr > -1 && yc < n && yc > -1) {
						if(a[xr][yc]==0 ) {
							a[xr][yc] = a[x2][y2] + 1;
							q.add(new int[] {xr, yc});
						}else if(a[xr][yc]==-2) {
							result = a[x2][y2] + 1;
							q.clear();
							break;
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
