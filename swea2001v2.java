import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			int[][] arr = new int[n][n];
			int[][] max_sum = new int[n][n];
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];
					if(i>0) max_sum[i][j] = sum + max_sum[i-1][j];
					else max_sum[i][j] = sum;
				}
			}
			
			int max = 0;
			
			for(int i = m-1; i < n; i++ ) {
				for(int j = m-1; j <n; j++) {
					int sum = max_sum[i][j];
					if(i>m-1) sum -= max_sum[i-m][j];
					if(j>m-1) sum -= max_sum[i][j-m];
					if(i>m-1&&j>m-1) sum+= max_sum[i-m][j-m];
					if(max<sum) max = sum;
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
