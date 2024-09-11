package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346_풍선터트리기_데큐 {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n = Integer.parseInt(br.readLine());
	// 링크드 리스트로 풍선 배치를 구현한다. 특정 인덱스를 삭제하면 자동으로 인덱스가 이동한다. 
	Deque<Integer> dq = new ArrayDeque<>();
	int[] order = new int[n+1];
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	// 링크드 리스트에 풍선 초기화 
	for(int i = 1; i <= n; i++) dq.addLast(i);
	// 각 풍선 안에 있는 숫자 저장 
	for(int i = 1; i <= n; i++) order[i] = Integer.parseInt(st.nextToken());
	
	for(int i = 0; i < n-1; i++) {
		int num = dq.pollFirst();
		sb.append(num+" ");
		int order_num = order[num];
		if(order_num>0) {
			for(int j = 0; j< order_num-1; j++) {
				dq.addLast(dq.pollFirst());
			}
		}
		else {
			for(int j = 0; j< -1*order_num; j++) {
				dq.addFirst(dq.pollLast());
			}
		}
	}
	sb.append(dq.peek());

	// 결과 출력
	System.out.print(sb);
	}
}
