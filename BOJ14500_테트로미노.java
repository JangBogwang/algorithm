package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ14500_테트로미노 {
	
	static int[][][] tech = 
		   {{{0,0},{0,1},{1,0},{1,1}},
			{{0,0},{0,1},{0,2},{0,3}},
			{{0,0},{1,0},{2,0},{3,0}},
			{{0,0},{0,1},{1,1},{1,2}},
			{{0,0},{0,1},{-1,1},{-1,2}},
			{{0,0},{1,0},{1,1},{2,1}},
			{{0,0},{1,0},{1,-1},{2,-1}},
			{{0,0},{0,1},{0,2},{1,1}},
			{{0,0},{0,1},{0,2},{-1,1}},
			{{0,0},{1,0},{2,0},{1,1}},
			{{0,0},{1,0},{2,0},{1,-1}},
			{{0,0},{0,1},{0,2},{1,2}},
			{{0,0},{0,1},{0,2},{-1,2}},
			{{0,0},{1,0},{2,0},{2,1}},
			{{0,0},{1,0},{2,0},{2,-1}},
			{{0,0},{0,-1},{0,-2},{-1,-2}},
			{{0,0},{0,-1},{0,-2},{1,-2}},
			{{0,0},{-1,0},{-2,0},{-2,-1}},
			{{0,0},{-1,0},{-2,0},{-2,1}},
		   };
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int max = 0; 
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m; j++) {
				for(int k = 0; k < 19; k++) {
					int sum = 0;
					for(int l = 0; l < 4; l++) {
						int r = tech[k][l][0];
						int c = tech[k][l][1];
						if(i+r>-1&&i+r<n&&j+c>-1&&j+c<m){
							sum += arr[i+r][j+c]; 
						}
						else break;
					}
					if(sum>max) max = sum;
				}
			}
		}
		
		
		System.out.print(max);
	}

}
