package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 14228kb, 시간: 100ms;

public class BOJ16928_뱀과사다리게임 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] next = new int[101];
		
		int[] dp = new int[101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			next[x] = y;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dp[1] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i <= 6; i++) {
				if(now+i<=100&&dp[now+i] > dp[now]+1) {
					dp[now+i] = dp[now]+1;
					int temp = next[now+i];
					if(temp!=0) {
						if(dp[temp] > dp[now+i]) {
							dp[temp] = dp[now+i];
							q.add(temp);
						}
					}else if(temp==0){
						q.add(now+i);
					}
				}
			}
		}
		
		System.out.print(dp[100]);
	}
}
