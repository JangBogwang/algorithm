import java.io.*;
import java.util.*;

//메모리: 18364kb, 시간: 140ms
public class BOJ28069_김밥천국의계단 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
					
		for(int i = 1; i < n; i++) {
			if(dp[i+1] > dp[i]+1)
				dp[i+1] = dp[i]+1;
			int x = i+i/2;
			if(x <= n && dp[x] > dp[i]+1)
				dp[x] = dp[i]+1;
		}

		
		String r = dp[n]<=k? "minigimbob" : "water";
		System.out.print(r);
	}
}
