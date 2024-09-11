package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_10반_장보광 {
	static int[] a; // 등번호 저장
	static int n; // 선수의 수 저장 
	static int m; // 수상자 수 
	static int k; // 수상자 번호 합계
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = new int[n];
			
			// 선수들의 등번호 저장 
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			search(0, 0, 0);
			for(int i = m; i > 1; i--) {
				count *= i;
			}
			if(count == 0) count = -1;
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int now, int sum, int num) {
		if(now == n) {
			if(sum == k && num == m) count++;
		}
		else {
			int sum2 = sum+a[now];
			if(sum2 <= k && num+1 <= m) search(now+1, sum2, num+1);
			if(sum <= k && n - 1 - now >= m - num) search(now+1, sum, num);
		}
	}
}
