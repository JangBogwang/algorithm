package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1970_쉬운거스름돈 {
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#"+t+"\n");
			for(int i = 0; i < 8; i++) {
				int now = money[i];
				if(n >= now) {
					int temp = n/now;
					sb.append(n/now+" ");
					n = n%now;
				}else sb.append("0 ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
