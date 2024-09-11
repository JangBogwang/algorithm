package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 15396kb. 시간: 124ms

public class BOj13335_트럭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int sum = 0; // 현재 다리 위 트럭의 무게 함 
		Queue<Integer> q = new LinkedList<>(); // 다리 위에 있는 트럭 저장 
		Queue<Integer> q2 = new LinkedList<>(); // 다리 위에 올라갈 대기 트럭 
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 다리 위에 올라갈 트럭 리스트
		for(int i = 0; i < n; i++) q2.add(Integer.parseInt(st2.nextToken()));
		
		
		int time = 0; // 걸린 시간 
		// 다리 위에 올라가기를 기다리는 트럭이 존재하는 한 반복문 실행 
		while(!q2.isEmpty()) {
			time++; // 시간+1
			int t = q2.peek(); // 대기열 트럭 첫 번째의 무게
			// 만약에 다리 위에 트럭이 차 있을 경우 맨 앞에 있는 트럭이 빠져 나온다. 
			if(q.size()==w) sum -= q.poll();  
			
			// 무게가 최대 하중을 넘어설 경우 트럭이 타지 않는다. 
			if(sum+t > l) q.add(0);
			// 아닐 경우 트럭이 다리 위에 올라간다. 
			else {
				q2.poll();
				q.add(t);
				sum += t;
			}
		}
		// 마지막 트럭이 다리 위에 올라선 순간 반복문이 종료 되었으므로
		// 마지막 트럭이 빠져 나올 수 있도록 다리 길이 만큼 시간을 더해준다.
		time += w;
		System.out.print(time);
	}
}
