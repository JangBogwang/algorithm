package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404_플로이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<int[]>[] al = new ArrayList[n+1]; 
		for(int i = 0; i < n+1; i++) al[i] = new ArrayList<>();
		int[][] min_d = new int[n+1][n+1];
		
		for(int i = 0; i < n+1; i++) {
			Arrays.fill(min_d[i],10000001);
		}
		
		// 경로 저장 
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(min_d[a][b] == 0 || min_d[a][b] > c) {
				min_d[a][b] = c;	
			}
		}
		
		
		for(int k = 1; k <=n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i!=j&&min_d[i][j] > min_d[i][k] + min_d[k][j]) {
						min_d[i][j] = min_d[i][k] + min_d[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(min_d[i][j]==10000001) {
					min_d[i][j] = 0;
				}
			}
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				sb.append(min_d[i][j]+" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
