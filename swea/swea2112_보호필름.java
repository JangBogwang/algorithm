package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2112_보호필름 {
	static int n;
	static int m; 
	static int k;
	static int[][] a; // 백업용 배열 
	static int[][] b; // 실제 계산할 때 
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = new int[n][m];
			b = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
					b[i][j] = a[i][j];
				}
			}
			int[][] c = a;
			// 각 경우의 수 별로 
			min = Integer.MAX_VALUE;
			search(0, 0);
			sb.append("#"+t+" "+(min)+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int now, int num) {
		if(now==n) {
			for(int j = 0; j < m; j++) {
				int l = 0;
				int max = 0;
				for(int i = 0; i < n; i++) {
					if(i > 0 && b[i][j] != b[i-1][j]) l = 0;
					l++;
					if(l > max) max = l;
				}
				if(max < k) return;
			}
			if(min > num) min = num;
			
		}else {
			search(now+1, num);
			if(num < k) {
				for(int i = 0; i < m; i++) b[now][i] = 1;
				search(now+1, num+1);
				for(int i = 0; i < m; i++) b[now][i] = 0;
				search(now+1, num+1);
				for(int i = 0; i < m; i++) b[now][i] = a[now][i];	
			}
		}
	}
}
