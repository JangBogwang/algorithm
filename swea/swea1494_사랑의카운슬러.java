package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1494_사랑의카운슬러 {
	static int n;
	static int[][] a;
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			a = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++)
					a[i][j] = Integer.parseInt(st.nextToken());
			}
			
			min = Long.MAX_VALUE;
			search(0,0,0,0);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int x, int y, int now, int count) {
		if(now != n) {
			int a1 = a[now][0];
			int a2 = a[now][1];
			if(count<n/2){
				if(n/2 - count < n - now)search(x+a1, y+a2, now+1, count);
				search(x-a1, y-a2, now+1, count+1);
			}else{
				search(x+a1, y+a2, now+1, count);
			}
		}else {
			long temp = (long)x*x + (long)y*y;
			if(temp < min) min = temp;
		}
	}
}
