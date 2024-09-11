package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 메모리: 143112kb, 시간: 564ms
public class BOJ1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] str = br.readLine().toCharArray();
		Deque<Character> sl = new ArrayDeque<>();// 커서 왼쪽의 문자열 저장하는 자료구조  
		Deque<Character> sr = new ArrayDeque<>();// 커서 오른쪽의 문자열 저장하는 자료 구조 
		
		// 문자열을 저장. 
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < str.length; i++) sl.addLast(str[i]);
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("L")) {
				// 커서 왼쪽의 문자를 오른쪽의 문자에 더한다. 
				if(!sl.isEmpty()) sr.addFirst(sl.pollLast());		
			}else if(s.equals("D")) {
				// 커서 오른쪽의 문자를 왼쪽에 더한다. 
				if(!sr.isEmpty()) sl.addLast(sr.pollFirst());
			}else if(s.equals("B")) {
				// 커서 왼쪽 문자 삭제 
				sl.pollLast();
			}else if(s.equals("P")) {
				// 커서 왼쪽에 문자 추가 
				sl.addLast(st.nextToken().charAt(0));
			}
		}
		//커서 왼쪽의 문자를 결과에 추가 
		while(!sl.isEmpty()) sb.append(sl.pollFirst());
		// 커서 오른쪽의 문자를 결과에 추가 
		while(!sr.isEmpty()) sb.append(sr.pollFirst());
		
		System.out.print(sb);
	}
}
