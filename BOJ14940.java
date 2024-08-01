import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14940{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] r = {1, 0, -1, 0};
		int[] c = {0, 1, 0, -1};
		
		
		int[] p = new int[3];
		int[][] arr = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[][] result = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(result[i], -1);
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer str2 = new StringTokenizer(br.readLine());
			for(int j = 0; j <m; j++) {
				arr[i][j] = Integer.parseInt(str2.nextToken());
				if(arr[i][j]!=1) {
					visited[i][j] = true;
					result[i][j] = 0;
					if(arr[i][j]==2) {
						p[0] = i;
						p[1] = j;
					}
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(p);
		while(!q.isEmpty()) {
			p = q.poll();
			int x = p[0];
			int y = p[1];
			for(int j = 0; j <4; j++) {
				int xr = x+r[j];
				int yc = y+c[j];
				if(xr<n&& xr>-1&&yc<m&&yc>-1&&(!visited[xr][yc])) {
					int[] p2 = {xr,yc};
					result[xr][yc] = result[x][y]+1;
					visited[xr][yc] = true;
					q.add(p2);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}