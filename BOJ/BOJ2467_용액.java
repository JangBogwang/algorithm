package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467_용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		int s = 0;
		int e = n-1;
		int min = Math.abs(a[s]+a[e]);
		int[] result = new int[] {s,e};
		
		while(s!=e) {
			int ns = s+1;
			int ne = e-1;
			if(Math.abs(a[s]+a[ne]) < Math.abs(a[s]+a[e]))
				e = ne;
			else s = ns;
			
			if(Math.abs(a[s] + a[e]) <= min&&s!=e) {
				min = Math.abs(a[s] + a[e]);
				result[0] = s;
				result[1] = e;
			}
		}
		sb.append(a[result[0]]+" "+a[result[1]]);
		System.out.print(sb);
	}
}
