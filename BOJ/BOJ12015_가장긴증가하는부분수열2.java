package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n];
		
		int l = 0;
		for(int i = 0; i < n; i++) {
			int index = search(dp, a[i], l);
			if(index == l)
				l++;
			dp[index] = a[i];
		}
		
		System.out.print(l);
	}

	static int search(int[] dp, int num, int l) {
		int s = 0;
		int e = l-1;
		if(l==0||num > dp[l-1])
			return l;
		else{
			int result = 0;
			while(s <= e) {
				int m = (s+e)/2;
				if(dp[m] == num) 
					return m;
				else if(dp[m] < num) {
					s = m+1;
				}else {
					result = m;
					e = m-1;
				}
			}
			return result;
		}
	}
}
