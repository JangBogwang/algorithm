import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea6190_정곤이의단조증가하는수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] b = new int[n];			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					int a = b[i] * b[j];
					int c = a;
					int p = 10;
					boolean check = true;
					while(c > 0){
						int d = c%10;
						c = c/10;
						if(d > p) {
							check = false;
							break;
						}
						p = d;
					}
					if(check&&a>max) max = a;
				}
			}
			
			if(max == 0) max = -1;
			sb.append("#"+t+" "+max+"\n");

		}
		System.out.print(sb);
	}
}
