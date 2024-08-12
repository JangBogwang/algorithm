import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805_농작물수확하기 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int m = n/2;
			for(int i = 0; i < n;i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j < n;j++) {
					if(Math.abs(m-i)+Math.abs(m-i)<=m) sum+= Integer.parseInt(str[j]);
				}
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.print(sb);
	}
}
