import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리: 14476kb 시간:104ms;
public class BOJ12785_토쟁이의등굣길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		long[][] dp = new long[x1+1][y1+1];
		for(int i = 0; i < x1+1; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0; i < y1+1; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < x1 + 1; i++) {
			for(int j = 1; j < y1 + 1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				if(dp[i][j] >= 1000007) {
					dp[i][j] = dp[i][j]%1000007;
				}
			}
		}
		
		long sum = dp[x2-1][y2-1] * dp[x1-x2][y1-y2];
		if(sum >= 1000007)
			sum = sum%1000007;
		
		System.out.print(sum);
	}
}
