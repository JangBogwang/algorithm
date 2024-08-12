import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1860_진기의최고급붕어빵 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int k = Integer.parseInt(str[2]);
			int d = 0;
			String c = "Possible";
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] a = new int[n];
			
			for(int i = 0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(a);
			
			for(int i = 0; i < n; i++) {
				int b = (a[i]/m)*k-d;
				if(b <= 0) {
					c = "Impossible";
					break;
				}
				else d++;
			}
			
			sb.append("#"+t+" "+c+"\n");
		}
		System.out.print(sb);
	}
}
