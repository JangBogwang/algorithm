import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea5432_쇠막대기자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			char[] str = br.readLine().toCharArray();
			
			int sum = 0;
			int stick = 0;
			for(int i = 0; i < str.length-1; i++) {
				if(str[i]=='(') {
					if(str[i+1]=='(') {
						stick++;
						sum++;
					}
					else {
						sum +=stick;
						i++;
					}
				}
				else stick--;
			}
			
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.print(sb);
	}
}
