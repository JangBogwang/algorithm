package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] a =  br.readLine().toCharArray();
		
		char[] b = br.readLine().toCharArray();
		int n = a.length;
		int m = b.length;
		int[][] dp = new int[n+1][m+1];
		int max = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] = dp[i-1][j-1];
				if(a[i-1] == b[j-1]) dp[i][j] += 1;
				else if(dp[i][j] < dp[i][j-1]) {
					dp[i][j] = dp[i][j-1];
				}
				else if(dp[i][j] < dp[i-1][j]){
					dp[i][j] = dp[i-1][j];
				}

				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.print(max);
	}
}
