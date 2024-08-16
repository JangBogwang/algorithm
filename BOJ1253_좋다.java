import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] a = new long[n];
		boolean[] b = new boolean[n];
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(a);
		for(int i = 0; i < n; i++) {
			long x = a[i];
			int c = 0, d = n-1;
			while(c!=d) {
				if(a[c]+a[d]==x) {
					if(c != i && d != i) {
						count++;
						break;
					}
					else if(c == i) c++;
					else if(d == i) d--;
				}
				else if (a[c]+a[d]>x) d--;
				else c++;
			}
		}
		System.out.print(count);
	}
}
