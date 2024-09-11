package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 108528kb 시간: 416ms

public class BOJ2573_빙산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int sum = 0; // 빙산의 크기 저장
		int time = -1; // 걸린 시간 저장 
		int[] r = {1, -1, 0, 0};
		int[] c = {0, 0, 1, -1};
		int[][] a = new int[n][m];
		int[][] b = new int[n][m]; // 빙산 복제 
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited;
		int x = 0, y = 0;
		
		// 빙산 입력 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] > 0) {
					sum += a[i][j];
					x = i;
					y = j;
				}
			}
		}

		int sum1 = sum; // 빙산의 크기 저장
		// 반복문 조건 
		boolean check =true;

		// 빙산이 녹는 과정을 반복문으로 구현 

		while(check) {
			time++;
			if(sum==0) {
				time = 0;
				break;
			}
			//빙하가 녹은 후 덩어리 개수를 파악(x, y에서 bfs)
			q.add(new int[] {x,y});
			// bfs를 돌면서 만난 빙산의 크기 
			int sum2 = 0; 
			visited = new boolean[n][m];
			visited[x][y] = true;
			// 빙산 덩어리를 bfs로 구한다. 만약 빙하 전체 합계와 다르면 두 개 이상의 덩어리로 나뉜 것이다.
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x1 = now[0];
				int y1 = now[1];
				sum2 += a[x1][y1];
				for(int i = 0; i < 4; i++) {
					int xr = x1 + r[i];
					int yc = y1 + c[i];
					if(xr < n && xr > -1 && yc < m && yc > -1 ) {
						if(a[xr][yc]>0&&!visited[xr][yc]) {
							q.add(new int[] {xr,yc});
							visited[xr][yc] = true;
						}
						else if(a[xr][yc]==0&&!visited[xr][yc]) {
							if(a[x1][y1] > 0) {
								a[x1][y1]--;
								sum--;	
							}
						}
					}
				}
				if(a[x1][y1]!=0) {
					x = x1;
					y = y1;
				}
			}
			
			if(sum1 != sum2) {
				break;
			}
			else {
				sum1 = sum;
			}
		}

		System.out.print(time);
	}

}
