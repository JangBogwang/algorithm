package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {
	static int[] r = {1, -1, 0, 0};
	static int[] c = {0, 0, 1, -1};
	static int n;
	static int m;
	static int[][] map;
	static int[][][] distance;
	static int result;
	static int max_value = 1000000;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		distance = new int[n][m][2];
		char[] temp;
		for(int i = 0; i < n; i++) {
			temp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(temp[j]=='1')
					map[i][j] = 1;
				else map[i][j] = 0;
				distance[i][j][0] = max_value;
				distance[i][j][1] = max_value;
			}
		}
		distance[0][0][0] = 1;
		distance[0][0][1] = 1;
		
		bfs();

        int result = Math.min(distance[n-1][m-1][0], distance[n-1][m-1][1]);
        if (result == max_value) result = -1;
        System.out.println(result);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0}); 
        distance[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int broken = now[2];

            for (int i = 0; i < 4; i++) {
                int xr = x + r[i];
                int yc = y + c[i];

                if (xr < 0 || xr >= n || yc < 0 || yc >= m) continue;

                if (map[xr][yc] == 0 && distance[xr][yc][broken] > distance[x][y][broken] + 1) {
                    distance[xr][yc][broken] = distance[x][y][broken] + 1;
                    q.add(new int[] {xr, yc, broken});
                }

                if (map[xr][yc] == 1 && broken == 0 && distance[xr][yc][1] > distance[x][y][0] + 1) {
                    distance[xr][yc][1] = distance[x][y][0] + 1;
                    q.add(new int[] {xr, yc, 1});
                }
            }
        }
	}
}
