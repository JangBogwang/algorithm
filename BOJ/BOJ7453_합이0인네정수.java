package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ7453_합이0인네정수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long[][] a = new long[4][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) 
				a[j][i] = Long.parseLong(st.nextToken());
		}
		
		long[] s1 = new long[n*n];
		long[] s2 = new long[n*n]; 
		
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) 
				s1[index++]= a[0][i]+a[1][j];
		}
		index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) 
				s2[index++] = -(a[2][i]+a[3][j]);
		}
		
		Arrays.sort(s1);
		Arrays.sort(s2);
		long count = 0;
		
		index = 0;
		int index2 = 0;
		
		while(index < s1.length&&index2 < s2.length) {
			if(s1[index] == s2[index2]) {
				long temp = s1[index];
				long x = 0;
				while(index < s1.length&&s1[index]==temp) {
					index++;
					x++;
				}
				long y = 0;
				while(index2 < s2.length&&s2[index2]==temp) {
					index2++;
					y++;
				}
				count += x * y;
			}else if(s2[index2] > s1[index]) {
				index++;
			}else if(s2[index2] < s1[index]) {
				index2++;
			}
		}
		
		System.out.print(count);
	}
}
