import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea21131_행렬정렬 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] a = new boolean[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int b = Integer.parseInt(st.nextToken());
				if(b==j) a[j-1] = true; 
			}
			
			for(int i = 1; i < n; i++) br.readLine();
			int count = 0;

			for(int j = n-1; j > 1; j--) {
				if(!a[j]){
					for(int k = 1; k <= j; k++) a[k] = !a[k];
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
