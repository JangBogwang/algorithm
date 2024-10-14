package algorithm;

import java.util.Scanner;
// 메모리: 20340kb 시간: 184ms
public class BOJ1309_동물원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n][2];
		dp[0][0] = 1;
		dp[0][1] = 2;
		for(int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = 2 * dp[i-1][0] + dp[i-1][1];
			
			if(dp[i][0] >= 9901) 
				dp[i][0]%=9901;
			if(dp[i][1] >= 9901) 
				dp[i][1]%=9901;
		}
		long result = dp[n-1][0] + dp[n-1][1];
		if(result >= 9901)
			result%= 9901;
		System.out.print(result);
	}

}
