package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] a = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] dp = new ArrayList[n+1];
		
		for(int i = 0; i <= n; i++) 
			dp[i] =  new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			for(int j = i-1; j > -1; j--) {
				if(dp[j].isEmpty()) {
					if(dp[i].isEmpty()) {
						dp[i].add(a[i]);
					}
				}
				else if(dp[j].get(dp[j].size()-1) < a[i]&&dp[j].size()+1 >= dp[i].size()) {
					dp[i] = new ArrayList<>();  	
					for(int temp: dp[j]) {
						dp[i].add(temp);
					}
					dp[i].add(a[i]);
				}else if(dp[j].get(dp[j].size()-1) >= a[i]&&dp[j].size() >= dp[i].size()) {
					dp[i] = new ArrayList<>(); 	
					for(int k = 0; k < dp[j].size(); k++) {
						dp[i].add(dp[j].get(k));
					}
				}
			}
		}
		int size = dp[n].size();
		sb.append(size+"\n");
		
		for(int temp: dp[n]) {
			sb.append(temp+" ");
		}
		System.out.print(sb);
	}
}
