package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16946_벽부수고이동하기4 {
	static int n;
	static int m;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] d;
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	static int[] length;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		visited = new boolean[n][m];
		int[][] result = new int[n][m]; 
		d = new int[n][m]; // 그룹
		length = new int[n*m]; // 길리 
		
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(temp[j]=='1') 
					map[i][j] = true;
			}
		}
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!map[i][j]&&!visited[i][j]) { 
					bfs(i,j, index);
					index++;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j]) {
					int[] cd = {-1, -1, -1, -1};
					for(int k = 0; k < 4; k++) {
						int xr = i + r[k];
						int yc = j + c[k];
						if(check(xr, yc)&&!map[xr][yc]) {
							boolean o = true;
							for(int f = 0; f < k; f++) {
								if(cd[f] == d[xr][yc])
									o = false;			
							}
							if(o)
								cd[k] = d[xr][yc];
						}
					}
					for(int k = 0; k < 4; k++) {
						if(cd[k]!=-1) {
							result[i][j] += length[cd[k]];
						}
					}
					result[i][j] = (result[i][j]+1)%10;
				}
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(int x, int y, int index) {
		q = new LinkedList<>();
		int l = 0;
		q.add(new int[] {x,y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x1 = now[0];
			int y1 = now[1];
			d[x1][y1] = index;
			l++;
			for(int i = 0; i < 4; i++) {
				int xr = x1 + r[i];
				int yc = y1 + c[i];
				if(check(xr, yc)&&!map[xr][yc]&&!visited[xr][yc]) {
					visited[xr][yc] = true;
					q.add(new int[] {xr, yc});			
				}
			}
		}
		length[index] = l;
	}
	
	static boolean check(int x, int y) {
		if(x < n && x > -1 && y < m && y > -1)
			return true;
		return false;
	}
}
