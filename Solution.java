package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			
			double[][] a = new double[n][n];
			int [][] b = new int[n][n];
			double[][] pow = new double[n][2];
			StringTokenizer st;
			
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 && a[i][j]==1) {
						pow[j][0] = 1;
						pow[j][1] = 1;
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				int now = 1; 
				boolean check = false;
				for(int i = 1; i < n; i++) {
					if(a[i][j] == 1 && !check) {
						now = i;
						check = true; 
					}
					else if(a[i][j] == 0 && check) {
						b[now][j] = i - now;
						check = false; 
					}
					else if(i == n-1&&a[i][j]==1&&check) {
						b[now][j] = i - now + 1;
						check = false; 
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				if(pow[j][0] == 0) {
					continue;
				}
				else {
					for(int i = 1; i < n; i++) {
						if(b[i][j]>0) {
							if(pow[j][0] > b[i][j]) {
								pow[j][0] += b[i][j];
								pow[j][1] += b[i][j];
								i += b[i][j]-1;
							}
							else {
								for(int k = i - 1; k >= 0; k--) {
									if(pow[j][1]>0) {
										a[k][j] = 1;
										pow[j][1]--;
									}
									else a[k][j] = 0;
								}
								
								break;
							}
						}
						else if(b[i][j]==0) {
							pow[j][0] = pow[j][0]*1.9; 
						}
						
						if(i == n-1) {
							for(int k = i; k >= 0; k--) {
								if(pow[j][1]>0) {
									a[k][j] = 1;
									pow[j][1]--;
								}
								else a[k][j] = 0;
							}
						}
					}
				}
			}
			
			b = new int[n][n];
			pow = new double[n][2];
			for(int i = 0; i < n; i++) {
				if(a[i][0]==1) {
					pow[i][0] = 1;
					pow[i][1] = 1;
				}
			}
			
			for(int i = 0; i < n; i++) {
				int now = 1; 
				boolean check = false;
				for(int j = 1; j < n; j++) {
					if(a[i][j] == 1 && !check) {
						now = j;
						check = true; 
					}
					else if(a[i][j] == 0 && check) {
						b[i][now] = j - now;
						check = false; 
					}
					else if(j == n-1&&a[i][j]==1&&check) {
						b[i][now] = j - now + 1;
						check = false; 
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				if(pow[i][0] == 0) {
					continue;
				}
				else {
					for(int j = 1; j < n; j++) {
						if(b[i][j]>0) {
							if(pow[i][0] > b[i][j]) {
								pow[i][0] += b[i][j];
								pow[i][1] += b[i][j];
								j += b[i][j]-1;
							}
							else {
								for(int k = j - 1; k >= 0; k--) {
									if(pow[i][1]>0) {
										a[i][k] = 1;
										pow[i][1]--;
									}
									else a[i][k] = 0;
								}
								
								break;
							}
						}
						else if(b[i][j]==0) {
							pow[i][0] = pow[i][0]*1.9; 
						}
						
						if(j == n-1) {
							for(int k = j; k >= 0; k--) {
								if(pow[i][1]>0) {
									a[i][k] = 1;
									pow[i][1]--;
								}
								else a[i][k] = 0;
							}
						}
					}
				}
			}
			
			int r1 = 0;
			int r2 = 0;
			
			for(int i = 0; i < n; i++) {
				if(a[i][n-1]==1) r2++;
				if(a[n-1][i]==1) r1++;
			}
			
			
			sb.append("#"+t+" "+ r1+" "+r2+"\n");
		}
		System.out.print(sb);
	}
}
