package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea7733_치즈도둑 {
	static int[][] map;
	static int n;
	static boolean[][] visited; 
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int max, result;
		boolean[] taste = new boolean[101];
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max = 0;
			result = 1;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					taste[map[i][j]] = true;
					if(map[i][j] > max) max = map[i][j];
				}
			}
			
			for(int k = 0; k < max; k++) {
				if(taste[k]) {
					visited = new boolean[n][n];
					int count = 0;
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							if(!visited[i][j]&&map[i][j] > k) {
								bfs(i, j, k);
								count++;
							}
						}
					}
					if(count > result) result = count;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int x, int y, int k) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int xr = now[0] + r[i];
				int yc = now[1] + c[i];
				if(xr < n && xr > -1 && yc < n && yc > -1 && map[xr][yc] > k) {
					if(!visited[xr][yc]) {
						q.add(new int[] {xr, yc});
						visited[xr][yc] = true;	
					}
				}
			}
		}
	}
}
