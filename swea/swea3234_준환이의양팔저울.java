package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea3234_준환이의양팔저울 {
	static int n;
	static int count;
	static boolean[] visited;
	static int[] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			a = new int[n];
			for(int i =0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(a);
			count = 0;
			visited = new boolean[n];
			search(0, 0, 0);
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.print(sb);
	}
	
	public static void search(int now, int r, int l) {
		if(now == n) count++;
		else {
			int h = 0;
			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					h++;
					int b = a[i];
					visited[i] = true;
					search(now+1,r, l+b);
					if(r + b <= l) search(now+1, r+b,l);	
					visited[i] = false;
				}
				if(h == n - now) break;
			}	
		}	
	}
}
