import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int max = 0;
		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[1] = arr[1];
		max = dp[1];
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
			max = dp[2];
		}
		
		if(n > 2) {
			for(int i = 3; i <= n; i++) {
				int x1 = dp[i-3] + arr[i] + arr[i-1];
				int x2 = dp[i-2] + arr[i];
				int x3 = arr[i]+arr[i-1];
				if(i > 3)
					x3 += dp[i-4];
				
				if(x1 >= x2 && x1 >= x3)
					dp[i] = x1;
				else if(x2 >= x1 && x2 >= x3)
					dp[i] = x2;
				else 
					dp[i] = x3;
				
				if(dp[i] > max)
					max = dp[i];
			}
		}
					
		System.out.print(max);
		
	}
}
