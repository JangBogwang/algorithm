package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 메모리: 71776kb, 시간: 536ms 
public class BOJ11725_트리의부모찾기 {
	static ArrayList<Integer>[] map; // 다음 경로 저장 
	static int[] parent; // 부모 위치 저장 
	static boolean[] visited; // 방문한 노드 저장 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		map = new ArrayList[n+1];
		parent = new int[n+1];
		visited = new boolean[n+1];
		StringTokenizer st;
		
		// 배열 초기화  
		for(int i = 1; i <= n; i++) map[i] = new ArrayList<Integer>();
		
		// 노드 사이의 경로 저장 
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		
		// 경로 탐색, 1번 루트 노드부터 실행 
		search(1);
		// 출력 저장 
		for(int i = 2; i <= n; i++) sb.append(parent[i]+"\n");
		
		System.out.print(sb);
	}
	
	public static void search(int n) {
		ArrayList x = map[n];
		// 연결된 노드 모두 불러오기 
		for(int i = 0; i < x.size(); i++) {
			int y = (int) x.get(i);
			// 만약 다음 경로가 방문하지 않았다면 
			if(!visited[y]) {
				visited[y] = true;// 방문 여부 확인 
				parent[y] = n;// 부모 노드 저장 
				search(y);// 자식 노드에 대한 탐색 실행 
			}
		}
	}
}
