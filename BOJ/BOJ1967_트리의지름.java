package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1967_트리의지름 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<int[]> [] tree;
	static int n;
	static int max;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); 
		tree = new ArrayList[n+1];// 트리 선언
		//트리 초기화
		for(int i = 0; i < n+1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 트리 입력 
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree[a].add(new int[] {b, w});
		}
		max = 0;
		search(1);
		
		System.out.print(max);
	}
	
	static int search(int now) {
		ArrayList<int[]> temp = tree[now];
		if(temp.isEmpty()) return 0;
		int max_l = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int[] x: temp) {
			int l = search(x[0]) + x[1];
			max_l = Math.max(max_l, l);
			if(dq.size()==0) dq.add(l);
			else if(dq.size()==1) {
				if(l < dq.peek()) dq.addLast(l);
				else dq.addFirst(l);
			}
			else {
				if(l >= dq.peekFirst()) {
					dq.addFirst(l);
					dq.pollLast();
				}
				else if(l>dq.peekLast()) {
					dq.pollLast();
					dq.addLast(l);
				}
			}
		}
		int ll = 0;
		if(dq.size()==2) {
			 ll = dq.peekFirst()+dq.peekLast();
		}
		else {
			ll = dq.peekFirst();
		}
		max = Math.max(max, ll);
		
		return max_l;
	}
}
