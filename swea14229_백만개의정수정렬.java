package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea14229_백만개의정수정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			if(pq.size()==500001) {
				if(a < pq.peek()) {
					pq.add(a);
					pq.poll();
				}
			}else {
				pq.add(a);	
			}
		}
		
		System.out.print(pq.poll());
	}
}
