import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1959_두개의숫자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int max = 0; 
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) a[i] =  Integer.parseInt(st.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) b[i] =  Integer.parseInt(st2.nextToken());
			
			if(a.length >= b.length) max = mult(a,b);
			else max = mult(b,a);
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.print(sb);
	}
	
	static int mult(int[] ll, int[] sl) {
		int max = 0;
		int s = sl.length;
		int l = ll.length;
		for(int i = s-1; i < l; i++) {
			int sum = 0;
			for(int j = 0; j < s; j++) {
				sum += ll[i - j] * sl[s-1-j];
			}
			if(sum > max) max = sum;
		}
		return max;
	}
}
