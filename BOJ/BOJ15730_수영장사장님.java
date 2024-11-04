import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15730_수영장사장님 {
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0;
		int[][] map = new int[100][100]; 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] al = new int[10001];
		int index = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[100][100];
		
		
		for(int i = 1; i < n-1; i++) {
			for(int j = 1; j < m-1; j++) {
				index = 0;
				int min_d = Integer.MAX_VALUE;
				boolean check = true;
				q.add(i*100+j);
				al[index++] = q.peek();
				visited[i][j] = true;
				while(!q.isEmpty()&&check) {
					int now = q.poll();
					for(int k = 0; k < 4; k++) {
						int nx = now/100+r[k];
						int ny = now%100+c[k];
						if(!visited[nx][ny]) {
							if(map[nx][ny] <= map[i][j]) {
								if(nx==0||nx==n-1||ny==0||ny==m-1) {
									check = false;
									break;
								}else {
									q.add(nx*100+ny);
									al[index++] = nx*100+ny;
									visited[nx][ny] = true;
								}
							}else if(min_d > map[nx][ny]) {
								min_d = map[nx][ny];
							}	
						}
					}
				}
				
				q.clear();
				
				if(check) {
					for(int k = 0; k < index; k++) {
						int nx = al[k]/100;
						int ny = al[k]%100;
						result += min_d - map[nx][ny];
						map[nx][ny] = min_d;
						visited[nx][ny] = false;
					}
				}
				
				for(int k = 0; k < 100; k++) {
					Arrays.fill(visited[k], false);
				}
			}
		}
		System.out.print(result);
	}
}
