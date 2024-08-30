package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ13549_숨박꼭질3 {
	static int min;
	static int[] dp = new int[100001];
	static int b;
	static int a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		if(b <= a) {
			System.out.print(a -b);			
		}else {
			Arrays.fill(dp, Integer.MAX_VALUE);
			for(int i = 100000; i > -1; i--) {
				
				int m = Math.abs(i - a)+1;
				if(m < dp[i]) dp[i] = m;
				
				if(i <= 50000) {
					int num = i * 2;
					while(num <= 100000) {
						if(dp[num] > dp[i]) {
							dp[num]  = dp[i];
						}
						else break;
						num=2*num;
					}
				}
			}
			search(a, 0);
			System.out.print(dp[b]);
		}
	}
	
	public static void search(int num, int time) {
		dp[num] = time;
		if(num < b && num*2 <= 100000&& time < dp[num*2]) search(num*2, time);
		if(num+1<=b&& time+1 < dp[num+1]) search(num+1, time+1);
		if(num-1>=0&& time+1 < dp[num-1]) search(num-1, time+1);	
	}
}

