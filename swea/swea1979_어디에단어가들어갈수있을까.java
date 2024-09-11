import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class swea1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int[] c = new int[n];
			int r = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c2 = 0;
				for(int j = 0; j<n; j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a==1) {
						c2++;
						c[j]++;
						if(j == n-1) {
							if(c2==k) r++;
						}
						if(i == n-1) {
							if(c[j]==k) r++;
						}
						
					}
					if(a==0){
						if(c2==k) r++;
						if(c[j]==k) r++;
						c2 = 0;
						c[j] = 0;
					}
				}
				
			}
			sb.append("#"+t+" "+r+"\n");
		}
		System.out.print(sb);
	}
}
