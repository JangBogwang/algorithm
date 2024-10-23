import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22944_죽음의비 {
	static int d;
	static int[][] point;
	static boolean[] visited;
	static int count;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][n];
		count=0;
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(map[i][j]=='U') count++;
			}
		}
		
		int[] s = new int[2];
		point = new int[count+1][2];
		visited = new boolean[count+1];
		min = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j]=='S') 
					s = new int[] {i,j};
				if(map[i][j]=='U')
					point[index++] = new int[] {i,j};
				if(map[i][j]=='E')
					point[count] = new int[] {i,j};
			}
		}
		
		dfs(0, h, 0, s[0], s[1]);
		if(min==Integer.MAX_VALUE)
			min = -1;
		System.out.print(min);
		
	}
	
	static void dfs(int distance, int h, int u, int x, int y) {
		if(distance < min) {
			if(x == point[count][0] && y == point[count][1]) {
				min = distance;
			}else{
				for(int i = 0; i <= count; i++ ) {
					int temp = Math.abs(x - point[i][0])+Math.abs(y - point[i][1]);
					if(!visited[i]&&temp-1 < h+u) {
						int z = h;
						if(u-temp+1 < 0) 
							z += (u-temp+1);
						visited[i] = true;
						dfs(distance+temp, z, d-1, point[i][0], point[i][1]);
						visited[i] = false;
					}
				}
			}
		}
	}
}
