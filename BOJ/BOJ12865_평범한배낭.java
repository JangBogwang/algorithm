package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		
		int[][] a = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[w+1];
		int[] dp2 = new int[w+1];
		Arrays.fill(dp, 0);
		int max = 0;
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < w; j++) {
				if(j!=0&&dp[j]	==0) continue;
				int weight = j + a[i][0];
				int v = dp[j] + a[i][1];
				if(weight <= w) {
					dp2[weight] = v;
				}
			}
			
			for(int j = 1; j <= w; j++) {
				dp[j] = Math.max(dp[j], dp2[j]);
			}
		}
		for(int i = 0; i <= w; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}
