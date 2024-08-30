package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
			PriorityQueue<Integer> pq  = new PriorityQueue<>();//최솟값 출력 
			PriorityQueue<Integer> pq2  = new PriorityQueue<>(Collections.reverseOrder());//최댓값 출력 
			Map<Integer, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i = 0; i< n; i++) {
				st = new StringTokenizer(br.readLine());
				char in = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				if(in=='I') {
					count++;
					pq.add(a);
					pq2.add(a);
					map.put(a, map.getOrDefault(a, 0) + 1);
				}else if(in=='D') {
					if(count > 0) {
						count--;
						if(a == 1) {
							while(map.get(pq2.peek())<1) {
								pq2.poll();
							}
							int num = pq2.poll();
							int num2 = map.get(num);
							map.put(num, num2-1);
						}else {
							while(map.get(pq.peek())<1) {
								pq.poll();
							}
							int num = pq.poll();
							int num2 = map.get(num);
							map.put(num, num2-1);
						}						
					}
				}
			}
			
			long max = 0, min = 0;
			if(count == 0) {
				sb.append("EMPTY\n");
			}
			else {
				while(map.get(pq2.peek())<1) {
					pq2.poll();
				}
				max = pq2.peek();
				
				while(map.get(pq.peek())<1) {
					pq.poll();
				}
				min = pq.peek();
				sb.append(max+" "+min+"\n");
			}

		}
		System.out.print(sb);
	}
}
