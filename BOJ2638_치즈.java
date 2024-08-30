package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 41168kb, 시간: 212ms
public class BOJ2638_치즈 {
	// 변수 선언 
	static int n;
	static int m;
	static int[][] ch;
	static int count;
	static boolean[][] visited;
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ch = new int[n][m];
		count = 0;
		// 치즈 배열 초기화 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					count++;
					ch[i][j] = 5;// 치즈가 있는 칸을 5로 초기화 
				}
				else ch[i][j] = 0;
			}
		}
		
		int time = 0;
		while(count > 0) {
			visited = new boolean[n][m];
			// 치즈 바깥 영역이 연결되어 있다는 보장이 없으므로 바깥 영역에서 
			// BFS를 모두 돌린다. 
			
			// 끝에서 bfs
			for(int i = 0; i < n; i++) {
				if(!visited[i][0]&&ch[i][0]==0) bfs(i, 0);
				if(!visited[i][m-1]&&ch[i][m-1]==0) bfs(i, m-1);
			}
			
			// 끝에서 bfs
			for(int i = 1; i < m-1; i++) {
				if(!visited[0][i]&&ch[0][i]==0) bfs(0, i);
				if(!visited[n-1][i]&&ch[n-1][i]==0) bfs(n-1, i);
			}
			
			// 배열 초기화 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					// ch[i][j]가 3이하면 2면 이상 접촉한다는 의미 
					if(ch[i][j] <= 3 && ch[i][j] > 0) {
						count--; // 치즈 개수 감소 
						ch[i][j] = 0; // 값 0으로 초기화 
					}
					else if(ch[i][j] > 3) ch[i][j] = 5; // 치즈의 위치에서 값 5로 초기화 
				}
			}
			time++;
		}
		System.out.print(time);
	}
	
	// BFS 함수 
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int xr = now[0] + r[i];
				int yc = now[1] + c[i];
				if(xr > -1 && xr < n && yc > -1 && yc < m) {
					if(!visited[xr][yc]&&ch[xr][yc]==0) {
						visited[xr][yc] = true;
						q.add(new int[] {xr,yc});
					}
					if(ch[xr][yc] > 0) ch[xr][yc]--; 
				}
			}
		}
	}
}
