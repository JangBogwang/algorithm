import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17129_윌리암슨수액빨이딱다구리가정보섬에올라온이유 {
	static int[] r = {-1, 1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	
	static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Point s = new Point();
		int result = 0;
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		for(int i = 0; i < n; i++)
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < n; i++) {
			char[] a = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = a[j] - '0';
				if(map[i][j]==2) {
					s.x = i;
					s.y = j;
					visited[i][j] = 0;
				}else if(map[i][j]==1)
					visited[i][j] =  0;
			}
		}
		
		
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(map[now.x][now.y] > 2) {
				result = visited[now.x][now.y];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + r[i];
				int ny = now.y + c[i];
			
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[now.x][now.y]+1 < visited[nx][ny]) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = visited[now.x][now.y] + 1;
				}	
			}
		}
		
		if(result > 0) {
			System.out.println("TAK");
			System.out.print(result);
		}else {
			System.out.println("NIE");
		}
	}
}
