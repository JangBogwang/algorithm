package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654_N과M5 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static boolean[] visited;
	static int[] a;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		int[] b = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		nm(b,0);
		System.out.print(sb);
		
	}
	
	static void nm(int[] b, int l) {
		if(l == m) {
			for(int i = 0; i < m; i++) sb.append(b[i]+" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				b[l] = a[i];
				nm(b, l+1);
				visited[i] = false;
			}
		}
	}
}
