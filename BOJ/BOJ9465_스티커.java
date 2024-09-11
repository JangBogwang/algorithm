package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465_스티커 {
	static int[][] a;
	static int[][] b;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			a = new int[n][2];
			b = new int[n][3];
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					a[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			b[0][0] = a[0][0];
			b[0][1] = a[0][1];
			
			for(int j = 1; j < n; j++) {
				b[j][0] = Math.max(b[j-1][1], b[j-1][2]) + a[j][0];
				b[j][1] = Math.max(b[j-1][0], b[j-1][2]) + a[j][1];
				b[j][2] = Math.max(b[j-1][0], b[j-1][1]);
			}
			
			int max = 0;
			for(int j = 0; j < 3; j++) {
				max = Math.max(max, b[n-1][j]);
			}
			sb.append(max+"\n");
			
		}
		System.out.print(sb);
	}
}
