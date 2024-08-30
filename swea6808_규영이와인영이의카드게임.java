package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea6808_규영이와인영이의카드게임 {
	static int[] a; //규영
	static int[] b; //인영
	static boolean[] c;
	static boolean[] visited;
	static int win;
	static int lose;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			a = new int[9];
			b = new int[9];
			c = new boolean[19];
			visited = new boolean[9];
			win =0;
			lose = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				int d = Integer.parseInt(st.nextToken());
				a[i] = d;
				c[d] = true;
			}
			
			int index = 0;
			for(int i = 1; i <= 18; i++) {
				if(!c[i]) b[index++] = i;
			}
			
			match(0, 0, 0);
			sb.append("#"+t+" "+ win+" "+lose+"\n");
		}
		System.out.print(sb);
	}
	
	static void match(int now, int sum1, int sum2) {
		if(now==9) {
			if(sum1 > sum2) win++;
			else if(sum1 < sum2) lose++;
		}
		else {
			for(int i = 0; i < 9; i++) {
				if(!visited[i]) {
					visited[i] = true;
					if(a[now] > b[i]) match(now+1, sum1+a[now]+b[i], sum2);
					else match(now+1, sum1, sum2+a[now]+b[i]);
					visited[i] = false;
				}
			}
		}
	}
}
