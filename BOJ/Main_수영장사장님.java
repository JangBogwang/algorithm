import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_수영장사장님 {
	
	static class RC{
		int r;
		int c;
		int max;
		RC(int r, int c, int max){
			this.r = r;
			this.c = c;
			this.max = max;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pool();
	}

	static void pool() {
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if(visited[i][j]) continue;
				water(i, j);
			}
		}
	}

	static void water(int i, int j) {
		Queue<RC> que = new ArrayDeque<>();
		
	}

}
