package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629_곱셈 {
	static long a;
	static long b;
	static long c;
	static long[] remains = new long[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		remains[0] = 1;
		remains[1] = a%c;
		long r;
		if(remains[1]==0) {
			r = 0;
		}
		else r = d(b);
	
		System.out.print(r);
	}
	
	public static long d(long num) {
		int x = (int)num;
		if(x < 100000 && remains[x]!= 0) {
			return remains[x]; 
		}
		else {
			long y = (d(num/2)*d(num - num/2))%c;
			if(x < 100000) {
				remains[x] = y;
			}
			return y;
		}
	}
}
