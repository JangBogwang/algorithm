package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1865_웜홀 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String result;
		boolean check;
		int[][] map;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			result = "NO";
			check = false;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map = new int[n+1][n+1];
			for(int i = 0; i < n+1; i++) {
				Arrays.fill(map[i], 100000);
				map[i][i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if(map[a][b] > d) map[a][b] = d;
				if(map[b][a] > d) map[b][a] = d;
			}
			
			for(int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if(a == b) check = true;
				if(map[a][b] > -d) map[a][b] = -d;
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {
						if(map[i][k] + map[k][j] < map[i][j]) {
							map[i][j] = map[i][k]+map[k][j]; 
						}
					}
				}
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = i + 1; j <= n; j++) {
					if(map[i][j] + map[j][i] < 0) {
						check = true;
					}
				}
				if(check) break;
			}
			
			
			if(check) result = "YES";
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
	

}
