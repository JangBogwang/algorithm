package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] sum = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int temp_sum = 0;
			for(int j = 0; j < n; j++) {
				temp_sum+=Integer.parseInt(st.nextToken());
				sum[i][j] = temp_sum;
				if(i  > 0) sum[i][j] += sum[i-1][j]; 
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = sum[x2-1][y2-1];
			if(x1>1) result -= sum[x1-2][y2-1];
			if(y1>1) result -= sum[x2-1][y1-2];
			if(x1>1&&y1>1) result += sum[x1-2][y1-2];
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
