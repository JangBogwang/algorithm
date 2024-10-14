package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942_팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[n][n];
		
		for(int i = 0; i < n-1; i++) {
			map[i][i] = true;
			if(a[i]==a[i+1]) {
				map[i][i+1] = true;
				
				int k = 1;
				while(i - k > -1 && i + 1 + k < n) {
					if(a[i-k]==a[i+1+k]) {
						map[i-k][i+1+k] = true;
						k++;
					}
					else break;
				}
			}
			if(i > 0 && a[i-1]==a[i+1]) {
				map[i-1][i+1] = true;
				
				int k = 1;
				while(i-1-k > -1 && i + 1 + k < n) {
					if(a[i-k-1]==a[i+1+k]) {
						map[i-k-1][i+1+k] = true;
						k++;
					}
					else break;
				}
			}
		}
		map[n-1][n-1] = true;
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(map[x-1][y-1])
				sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.print(sb);
	}
}
