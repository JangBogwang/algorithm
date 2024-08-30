package algorithm;

import java.util.Scanner;

public class BOJ15650_N과M2 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] a = new int[m];
		for(int i = 1; i <= n - m + 1; i++) {
			a[0] = i;
			nm(a, i, 1);
		}
		System.out.print(sb);
	}
	
	public static void nm(int[] a,int b, int l) {
		if(l == m) {
			for(int j = 0; j < m; j++) {
				sb.append(a[j]+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = b + 1; i <= n; i++ ) {
				a[l] = i;
				nm(a, i, l+1);
			}			
		}
	}
}
