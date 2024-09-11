package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea8382 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] a = new int[2];
		int[] b = new int[2];
		int result = 0;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			b[0] = Integer.parseInt(st.nextToken());
			b[1] = Integer.parseInt(st.nextToken());
			if(Math.abs(Math.abs(a[0] - b[0]) - Math.abs(a[1] - b[1]))<2) 
				result = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
			else {
				int max = Math.max(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1]));
				result = 2 * max;
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
