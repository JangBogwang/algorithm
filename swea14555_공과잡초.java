import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea14555_공과잡초 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split("");
			int r = 0;
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("(")&&str[i+1].equals("|"));
				if(str[i].equals(")")) r++;}
			sb.append("#").append(t).append(" ").append(r).append("\n");
		}
		System.out.print(sb);
	}
}
