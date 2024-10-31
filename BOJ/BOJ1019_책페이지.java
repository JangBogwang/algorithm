
import java.util.Scanner;

public class BOJ1019_책페이지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		long m = Integer.parseInt(n);
		char[] arr = n.toCharArray();
		long[] result = new long[10]; // 결과 저장 
		long[] mid = new long[10]; // 각 자리수 저장 
		
		long[][][] dp = new long[11][10][10];
		
		for(int i = 1; i <= 10; i++) {
			int count = 0;
			for(int j = 0; j < 10; j++) {
				dp[i][0][j] += dp[i-1][9][j] + dp[i-1][0][j];
			}
			dp[i][0][9] += fun(i-2);

			for(int j = i - 3; j > 0; j--) {
				dp[i][0][0] += fun(j);
			}
			
			for(int j = 0; j < 10; j++) {
				dp[i][1][j] += dp[i][0][j];
			}
			
			dp[i][1][1]++;
			dp[i][1][0] += i - 1;

			
			for(int j = 2; j < 10; j ++) {
				count = 0;
				for(int k = 0; k < 10; k++) {
					dp[i][j][k] = dp[i][j-1][k] + dp[i][0][k];
				}
				dp[i][j][j-1] += fun(i-1);
				dp[i][j][j]++;
				dp[i][j][0] += i - 1;
				for(int k = i-2; k >0; k--) {
					dp[i][j][0] += fun(k);
				}
			}
		}
		
		int size = arr.length;
		int div = (int) Math.pow(10, size-1);
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i] - '0';
			if(num==0) {
				mid[0]++;
				size--;
				div/=10;
				continue;
			}
			int temp = num * div;
			for(int j = 0; j < 10; j++) {
				result[j] += dp[size][num][j] + temp * mid[j];
			}
			if(i!=0) {
				int count3 = 0;
				for(int j = size - 1; j > 0; j--)
					count3 += fun(j);
				result[0] += count3;
			}
			div/=10;
			mid[num]++;
			size--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			sb.append(result[i]+" ");
		}
		System.out.print(sb);
	}
	
	static int fun(int l) {
		int result = 1;
		for(int i = 0; i < l; i++) {
			result *= 10;
		}
		return result - 1;
	}
}

 
