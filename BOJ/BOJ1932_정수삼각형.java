package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932_정수삼각형 {
	static int n;
	static BufferedReader br;
	static StringTokenizer st;
	static int max;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] a = new int[1];
		a[0] = Integer.parseInt(br.readLine());
		max = 0;
		search(a,1);
		System.out.print(max);
	}
	
	public static void search(int[] a, int l) throws IOException {
		int[] c = a; 
		if(l == n) {
			for(int i = 0; i < n; i++) {
				max = Math.max(max, a[i]);
			}
		}else {
			int[] b = new int[l+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < l+1; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(i == 0) b[0] = num + a[0];
				else if(i == l) b[l] = num + a[l-1];
				else b[i] = Math.max(a[i-1], a[i]) + num; 
			}
			search(b,l+1);
		}
	}
}
