import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split("");
			String now = "0";
			int r = 0;
			for(int i = 0; i < str.length; i++) {
				if(!str[i].equals(now)){
					r++;
					now = str[i];
				}
			}
			sb.append("#"+t+" "+r+"\n");
		}
		System.out.print(sb);
	}
}
