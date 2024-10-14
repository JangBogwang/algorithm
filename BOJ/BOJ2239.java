package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 {
	static int[][] result = new int[9][9];
	static boolean[][] low = new boolean[9][10]; // 가로줄 체크
	static boolean[][] col = new boolean[9][10]; // 세로줄 체크
	static boolean[][][] rect = new boolean[3][3][10];
	static boolean[][] map = new boolean[9][9];
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		for(int i = 0; i < 9; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				int num = temp[j] - '0';
				result[i][j] = num;
				if(num!=0) {
					low[i][num] = true;
					col[j][num] = true;
					rect[i/3][j/3][num] = true; 
					map[i][j] = true;
				}
			}
		}
		search(0);

		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	static void search(int now) {
		if(now == 81||check) {
			check = true;
			return;
		}
		int x = now/9;
		int y = now%9;
		if(map[x][y]) {
			search(now+1);
		}else {
			for(int i = 1; i <=9; i++) {
				if(!low[x][i]&&!col[y][i]&&!rect[x/3][y/3][i]) {
					result[x][y] = i;
					low[x][i] = true;
					col[y][i] = true;
					rect[x/3][y/3][i] = true;
					search(now+1);
					if(check) break;
					low[x][i] = false;
					col[y][i] = false;
					rect[x/3][y/3][i] = false;
				}
			}
		}
	}
}
