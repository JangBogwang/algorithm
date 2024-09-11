package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ11053_가장긴증가하는부분수열 {
	static boolean[] visited = new boolean[1001];
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(dp[i] > max) max = dp[i];
		}

		System.out.print(max);
	}
}
