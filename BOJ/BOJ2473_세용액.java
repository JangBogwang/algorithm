package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473_세용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long [] a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		long min = 3000000000l;
		int[] result = new int[3];
		for(int i = 0; i < n-2; i++) {
			for(int j = i + 2; j < n; j++) {
				if(Math.abs(a[i]+a[j-1]) < (Math.abs(a[i]+a[j])))
						continue;
				for(int k = i+1; k < j; k++) {
					if(Math.abs(a[i]+a[j]+a[k]) < min) {
						min = Math.abs(a[i]+a[j]+a[k]);
						result[0] = i;
						result[1] = k;
						result[2] = j;
					}
				}
			}
		}
		
		
		sb.append(a[result[0]]+" "+a[result[1]]+" "+a[result[2]]);
		System.out.print(sb);
	}
}
