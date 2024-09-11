package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리: 16136kb 시간: 132ms;
public class BOJ25342_최대최소공배수 {
	public static void main(String[] main) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			long n = Long.parseLong(br.readLine());
			long result = 1;
			if(n%2==0) {
				if(n%3!=0) 
					result = (long)n * (n - 1) * (n - 3);
				else 
					result = (long)(n-1) * (n - 2) * (n - 3);  
			}
			else 
				result = (long)n*(n-1)*(n-2);
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
