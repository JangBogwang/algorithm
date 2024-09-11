import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1010 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<T+1; t++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			sb.append((long)f2(m,n,m-n)+"\n");
		}
		System.out.print(sb);
	}
	
	public static double f2(double m, double n, double l) {
		if(m<=n) return 1;
		else return m*f2(m-1,n,l-1)/l;
	}
}
