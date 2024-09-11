package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


//메모리: 16164kb, 시간: 132ms
public class BOJ2346_풍선터트리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int count = n;
		// 링크드 리스트로 풍선 배치를 구현한다. 특정 인덱스를 삭제하면 자동으로 인덱스가 이동한다. 
		LinkedList<Integer> ll = new LinkedList<>();
		int[] order = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 링크드 리스트에 풍선 초기화 
		for(int i = 1; i <= n; i++) ll.add(i);
		// 각 풍선 안에 있는 숫자 저장 
		for(int i = 1; i <= n; i++) order[i] = Integer.parseInt(st.nextToken());
		
		int now = 0;
		
		for(int i = 0; i < n - 1; i++) {
			// 현재 위치의 풍선을 터트리고 풍선 안 숫자를 저장한다. 
			int num = ll.get(now);
			int now_order = order[num];
			sb.append(num+" ");
			ll.remove(now);
			count--;
			
			//다음 위치 탐색 
			// 양의 방향으로 움직일 때와 음의 방향으로 움직일 때 두 가지 조건을 확인한다.  
			if(now_order > 0) {
				now += (now_order - 1);
				if(now >= count) now = now%count;
			}
			else {
				now += now_order;
				if(now < 0) {
					int temp = (now*-1)%count;
					if(temp == 0) now = 0;
					else now = count - temp;
				}
			}
		}
		// 마지막 남은 풍선 출력 
		sb.append(ll.get(0));
		// 결과 출력
		System.out.print(sb);
	}
}
