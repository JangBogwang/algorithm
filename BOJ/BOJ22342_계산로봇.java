package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22342_계산로봇 {
	static int[] r = { -1, 0, 1};
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i = 0; i < n;  i++) {
			char[] a = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = a[j] - '0';
			}
		}
		
		int max = 0;
		int[][] dp = new int[n][m];

		for(int i = 0; i < n; i++) {
			dp[i][0] = map[i][0];
			if(m > 1 && dp[i][0] > max)
				max = dp[i][0];
		}
		for(int j = 0; j < m-2; j++) {
			for(int i = 0; i < n; i++) {
				for(int k = 0; k < 3; k++) {
					int next = i + r[k];
					if(next > -1 && next < n&& dp[next][j+1] < dp[i][j]+map[next][j+1]) {
						dp[next][j+1] = dp[i][j]+map[next][j+1];
						if(max < dp[next][j+1])
							max = dp[next][j+1];
					}
				}
			}
		}
		System.out.print(max);
	}
}
