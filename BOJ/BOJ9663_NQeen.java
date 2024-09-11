package algorithm;

import java.util.Scanner;

public class BOJ9663_NQeen {
	static int n;
	static int[][] chess;
	static int count;
	static int[] r = { -1, 1, 1, -1, 1, 0, -1, 0};
	static int[] c = { -1, 1, -1, 1, 0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		chess = new int[n][n];
		count = 0;
		game(0);
		System.out.print(count);
	}
	
	static void game(int now) {
		if(now==n) count++;
		else {
			for(int i = 0; i < n; i++) {
				if(chess[now][i]==0) {
					set(now, i, 1);
					game(now+1);
					set(now, i, -1);
				}
			}
		}
	}
	
	static void set(int x, int y, int add) {
		chess[x][y] +=add;
		for(int i = 0; i< 8; i++) {
			int xr = x + r[i];
			int yc = y + c[i];
			while(xr<n&&xr>-1&&yc<n&&yc>-1) {
				chess[xr][yc]+=add;
				xr += r[i];
				yc += c[i];
			}
		}
	}
}
