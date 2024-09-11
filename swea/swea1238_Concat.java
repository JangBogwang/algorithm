package algorithm;

import java.io.*;
import java.util.*;

public class swea1238_Concat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int[][] map = new int[101][101];
			for(int i = 0; i < 101; i++) {
				Arrays.fill(map[i], 10000);
				map[i][i] = 0;
			}
			st = new StringTokenizer(br.readLine()); 
			for(int i = 0; i < n/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				map[s][e] = 1;
			}
			
			for(int k = 1; k < 101; k++) {
				for(int i = 1; i < 101; i++) {
					for(int j = 1; j < 101; j++) {
						if(map[i][k]+map[k][j] < map[i][j])
							map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
			
			int max = 0;
			int result = 0;
			for(int i = 1; i < 101; i++) {
				if(map[start][i] >= max && map[start][i]!=10000) {
					result = i;
					max = map[start][i]; 
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
