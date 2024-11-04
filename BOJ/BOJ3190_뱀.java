import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190_뱀 {
	static class next{
		int t;
		char d;
		
		next(int t, char d){
			this.t = t;
			this.d = d;
		}
	}
	
	static int[] r = {0, -1, 0, 1};
	static int[] c = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		boolean[][] apple = new boolean[n][n];
		boolean[][] map = new boolean[n][n];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			apple[a][b] = true;
		}
	
		int l = Integer.parseInt(br.readLine());
		Queue<next> q = new LinkedList<>();
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char[] b = st.nextToken().toCharArray();
			q.add(new next(a, b[0]));
		}
		
		Deque<Point> body = new ArrayDeque<>();
		body.addLast(new Point(0,0));
		map[0][0] = true;
		int count = 0;
		int time = 0;
		int d = 2;
		while(true) {
			int nx = body.getLast().x + r[d];
			int ny = body.getLast().y + c[d];
			time++;
			if(nx==n || ny == n || nx == -1 || ny == -1) break;
			if(map[nx][ny]) break;
			map[nx][ny] = true;
			body.addLast(new Point(nx, ny));
			
			if(apple[nx][ny]) apple[nx][ny] = false;
			else {
				Point temp = body.pollFirst();
				map[temp.x][temp.y] = false;
			}

			if(!q.isEmpty()&&time == q.peek().t) {
			  char nd = q.poll().d;
			  if(nd == 'D') d++;
			  else d--;
			  if(d == -1) d = 3;
			  if(d == 4) d = 0;
			}

		}
	
		System.out.print(time);
	}
}
