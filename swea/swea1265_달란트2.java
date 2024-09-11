import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class swea1265_달란트2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = a/b;
			int d = a%b;
			a = 1;
			for(int i = 0; i< b; i++) {
				if(i<d) a = a*(c+1);
				else a = a*c;
			}

			sb.append("#"+t+" "+a+"\n");
		}
		System.out.print(sb);
	}
}
