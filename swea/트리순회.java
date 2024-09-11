package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리순회 {
	static Map<Character, char[]> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] temp = new char[2];
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			temp[0] = st.nextToken().charAt(0);
			temp[1] = st.nextToken().charAt(0);
			map.put(a, new char[]{temp[0], temp[1]});
		}
		Map<Character, char[]> map2 = map;
		for(int i = 1; i < 4; i++) {
			search('A', i);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void search(char a, int b) {
		char[] temp = map.get(a);
		if(b==1) sb.append(a);
		if(temp[0]!='.') {
			search(temp[0], b);
		}
		if(b==2) sb.append(a);
		if(temp[1]!='.') {
			search(temp[1], b);
		}
		if(b==3) sb.append(a);
	}
}
