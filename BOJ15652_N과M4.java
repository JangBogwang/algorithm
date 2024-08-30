package algorithm;

import java.util.Scanner;

public class BOJ15652_N과M4 {
	static StringBuilder sb = new StringBuilder(); 
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] num = new int[m];
		for(int i = 1; i <=n; i++) {
			num[0] = i;
			s(num, 1);
		}
		
		System.out.print(sb);
	}
	
	public static void s(int[] num, int l){
		if(l == m) {
			for(int i = 0; i < m; i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i = num[l-1]; i <= n; i++) {
				num[l] = i;
				s(num, l+1);
			}
		}
	}
}
