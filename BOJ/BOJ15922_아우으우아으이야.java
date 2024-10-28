import java.io.*;
import java.util.*;

public class BOJ15922_아우으우아으이야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long l = Integer.MIN_VALUE, r = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if(a >= l) {
				r += (b - a);
				l = b;
			}
			else if (b >= l) {
				r += b - l;
				l = b;
			}
			
		}
		System.out.print(r);
	}
}
