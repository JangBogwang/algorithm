package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1405_미친로봇 {
	static int n;
	static boolean[][] map;
	static double [] d = new double[4];
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	static double simple;
	
	// 메모리: 14912kb, 시간: 160ms
	// 핵심 아이디어: DFS를 활용한 경우의 수 탐색 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		// 확률 저장 
		for(int i = 0; i < 4; i++)
			d[i] = (double)Integer.parseInt(st.nextToken())/100;
		
		// 이동할 수 있는 최대 범위로 map을 만들었다.
		map = new boolean[2*n+1][2*n+1];
		// 가운데가 시작점, true 선언 
		map[n][n] = true;
		simple = 0;
		// DFS
		search(n,n,1, 0);
		System.out.print(simple);
	}
	
	// DFS
	static void search(int x, int y, double p, int l) {
		if(l<n) {
			// 4방향 탐색 
			// 이미 방문한 곳을 가면 단순하지 않으므로 
			// 방문하지 않은 곳일 경우만 DFS를 재귀함수로 호출한다. 
			for(int i = 0; i < 4; i++) {
				int xr = x + r[i];
				int yc = y + c[i];
				if(!map[xr][yc]) {
					map[xr][yc] = true;
					double p2 = p * d[i];
					search(xr, yc, p2, l+1);
					map[xr][yc] = false;
				}
			}
		}else {
			// 끝까지 도달할 경우 확률을 더해준다. 
			simple += p;
		}
	}
}
