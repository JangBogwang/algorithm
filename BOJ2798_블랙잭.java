import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798_블랙잭 {
	static int n;
	static int m;
	static int[] a;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		a = new int[n];
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		bj(0,0,0);
		System.out.print(max);
	}
	
	public static void bj(int l,int start,int sum){
		for(int i = start; i < n-2+l; i++) {
			if(l==2) {
				int x = sum+a[i];
				if(x>max&&x<=m) max = x;
			}
			else bj(l+1, i+1, sum+a[i]);
		}
	}
}
