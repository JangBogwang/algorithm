package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리: 16352kb 시간: 152ms
public class BOJ1012_유기농배추 {
	static int[] r = {1, -1, 0 ,0};
	static int[] c = {0, 0, 1, -1};
	static boolean[][] map;
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count;
		
		for(int t = 1; t <= T; t++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			// 배추밭을 boolean으로 저장. visited 안 쓰려고 
			map = new boolean[n][m];
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			// 탐색 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
	
	// BFS 진행
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = false;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int xr = now[0] + r[i];
				int yc = now[1] + c[i];
				if(xr < n && xr > -1 && yc < m && yc > -1 && map[xr][yc]) {
					map[xr][yc] = false;
					q.add(new int[] {xr, yc});
				}
			}
		}
	}
}
