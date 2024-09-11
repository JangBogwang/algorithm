package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea5658_보물상자비밀번호 {
	static StringBuilder sb = new StringBuilder();
	static char[] a;
	static int l;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Long> pq;
		
		for(int t = 1; t <= T; t++) {
			pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			long result = 0;
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			l = n/4;
			a = br.readLine().toCharArray();
			for(int i = 0; i < n; i++) {
				pq.add(trans(i));
			}
			
			int index = 1;
			while(!pq.isEmpty()) {
				result = pq.poll();
				if(!pq.isEmpty()) {
					while(result==pq.peek()) pq.poll();	
				}
				if(index == k) break;
				else index++;
			}	
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
	
	static long trans(int s) {
		long sum = 0;
		long mult = 1;
		for(int i = l - 1; i > -1; i--) {
			int now = (s + i) % n;
			long b = 0;
			if((int)a[now] < 58 && (int)a[now] > 47) b = (long)a[now] - '0'; 
			else b = (long)a[now] - 55;
			sum += (b*mult);
			mult *= 16;
		}
		return sum;
	}
}
