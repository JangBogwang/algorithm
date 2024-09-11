import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <=T; t++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			
			int[][] arr = new int[n][n];
			
			int max = 0; 
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					int sum = 0;
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i>=m-1&&j>=m-1) {
						for(int k = 0; k < m; k++) {
							for(int l = 0; l < m; l++) {
								sum+=arr[i-k][j-l];
							}
						}
					}
					if(max<sum) max = sum;
				}
			}
			sb.append("#"+t+" "+max+"\n");
			
		}
		System.out.print(sb);
	}
}
