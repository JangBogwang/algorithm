package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea5215_햄버거다이어트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] a = new int[n][2];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				a[i][0] = Integer.parseInt(st.nextToken());
				a[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[l+1];
			int[] dp2 = new int[l+1];
			Arrays.fill(dp, 0);
			int max = 0;
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < l; j++) {
					if(j!=0&&dp[j]==0) continue;
					int weight = j + a[i][1];
					int v = dp[j] + a[i][0];
					if(weight <= l) {
						dp2[weight] = v;
					}
				}
				
				for(int j = 1; j <= l; j++) {
					dp[j] = Math.max(dp[j], dp2[j]);
				}
			} 
			
			for(int j = 1; j <= l; j++) {
				max = Math.max(max, dp[j]);
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
