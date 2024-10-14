package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ컴백홈 {
	static int[] r = {-1, 1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	static int n;
	static int m;
	static int k;
	static boolean[][] map;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(temp[j]=='T') {
					map[i][j] = true;
				}
			}
		}
		map[n-1][0] = true;
		count =0;
		dfs(n-1,0,1);
		System.out.print(count);
	}
	
	static void dfs(int x, int y, int d) {
		if(d<k) {
			for(int i = 0; i < 4; i++) {
				int xr = x + r[i];
				int yc = y + c[i];
				if(xr > -1 && xr < n && yc < m && yc > -1 && !map[xr][yc]) {
					map[xr][yc] = true;
					dfs(xr,yc,d+1);
					map[xr][yc] = false;
				}
			}
		}else if(x == 0 && y == m-1 && d == k){
			count++;
		}
	}
}
