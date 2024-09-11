package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1244_최대상금 {
	static int max;
	static int n;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			char[] a = st.nextToken().toCharArray();
			int s = Integer.parseInt(st.nextToken());
			int[] b = new int[a.length];
			n = b.length;
			int[] ch = new int[10];
			check = false;
			for(int i = 0; i < a.length; i++) {
				b[i] = (int)a[i] - '0';
				ch[b[i]]++;
				if(ch[b[i]] > 1) check = true;
			}
			max = 0;
			search(b, s, 0);
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int[] b, int m, int now) {
		if(m == 0) {
			int sum = 0;
			int a = 1;
			for(int i = b.length-1; i > -1; i--) {
				sum += (a*b[i]);
				a *= 10;
			}
			if(sum > max) max =sum;
		}else if(m > 0&&now==n-1) {
			if((m%2)==1&&!check) swap(b, n-1, n-2);
			search(b, 0, now);
		}else {
			int max = 0;
			for(int i = now+1; i < n; i++) {
				if(b[i] > max && b[i] > b[now]) max = b[i];
			}
			if(max == 0) search(b, m, now+1);
			else {
				for(int i = now+1; i < n; i++) {
					if(b[i] == max) {
						swap(b, now, i);
						search(b, m -1, now+1);
						swap(b, now, i);
					}
				}
			}
		}
	}
	
	static void swap(int[] b, int x, int y) {
		int temp = b[x];
		b[x] = b[y];
		b[y] = temp;
	}
}
