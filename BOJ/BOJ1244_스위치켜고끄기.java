import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n]; 
		
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("1")) {
				int b = Integer.parseInt(str[1]);
				int c = 1;
				while(b*c<=n){
					a[b*c-1] = a[b*c-1]^1;
					c++;
				}
			}
			else {
				int b = Integer.parseInt(str[1]);
				int c = 1; 
				a[b-1] = a[b-1]^1;
				while(b+c-1<n && b-c-1>=0) {
					if(a[b+c-1]==a[b-c-1]) {
						a[b+c-1] = a[b+c-1]^1;
						a[b-c-1] = a[b-c-1]^1;
						c++;
					}
					else break;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			sb.append(a[i-1]+" ");
			if(i%20==0) sb.append("\n"); 
		}
		
		System.out.print(sb);
	}
}
