package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] a = new int[n][3];
		int[][] sum = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum[0][0] = a[0][0];
		sum[0][1] = a[0][1];
		sum[0][2] = a[0][2];
		
		for(int i = 1; i < n; i++) {
			sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + a[i][0];
			sum[i][1] = Math.min(sum[i-1][2], sum[i-1][0]) + a[i][1];
			sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + a[i][2];
		}
		
		int r = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++) r = Math.min(r, sum[n-1][i]);
		
		System.out.print(r);
		
	}
}
