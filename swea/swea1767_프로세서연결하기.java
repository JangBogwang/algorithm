package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1767_프로세서연결하기 {
	static int n;
	static int[][] a;
	static int[][] b;
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, -1, 1};
	
	static int count;
	static int length;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			a = new int[n][n];
			int[][] d  = new int[12][2];
			int size = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
					if(a[i][j]==1) {
						d[size][0] = i;
						d[size++][1] = j;
					}
				}
			}
			
			b = new int[size][2];
			for(int i = 0; i < size; i++) b[i] = d[i];
			count = 0;
			length = 0;
			search(0, 0, 0);
			sb.append("#"+t+" "+length+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int now, int d, int l) {
		if(now == b.length) {
			if(d > count) {
				count = d;
				length = l;
			}else if(d == count&&l < length) {
				length = l;
			}
		}else {
			int x = b[now][0];
			int y = b[now][1];
			for(int i = 0; i < 4; i++) {
				int xr = x + r[i];
				int yc = y + c[i];
				boolean check = true;
				while(check) {
					if(xr >= n || xr < 0 || yc >= n || yc < 0) {
						check = false;
					}else if(a[xr][yc]!=0) break;
					xr += r[i];
					yc += c[i];
				}
				
				if(!check) {
					int ll = 0;
					xr = x + r[i];
					yc = y + c[i];
					while(xr < n && xr > -1 && yc < n && yc > -1) {
						ll++;
						a[xr][yc] = 2;
						xr += r[i];
						yc += c[i];
					}
					search(now+1, d+1, l + ll);
					xr = x + r[i];
					yc = y + c[i];
					while(xr < n && xr > -1 && yc < n && yc > -1) {
						a[xr][yc] = 0;
						xr += r[i];
						yc += c[i];
					}
				}
			}
			search(now+1, d, l);
		}
	}
}
