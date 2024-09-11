import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
import java.awt.Point;

public class BOJ16236_아기상어 {
	static int n;
	static Point shark; 
	static int[][] a;
	static int size = 2;
	static int count = 0;
	static int distance = 0;
	static int[] r = {-1, 0, 1, 0};
	static int[] c = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j]==9) {
					shark = new Point(i,j);
					a[i][j] = 0;
				}
			}
		}
		boolean next = true;
		while(next) next = eat();
		
		System.out.print(distance);
	}
	
	public static boolean eat(){
		Queue<Point> p = new LinkedList<>();
		Queue<Point> u = new LinkedList<>();
		p.add(shark);
		boolean[][] visited = new boolean[n][n];
		int[][] dd = new int[n][n];
		visited[shark.x][shark.y] = true;
		boolean check = false;
		int min_d = 0;
		while(!p.isEmpty()) {
			Point now = p.poll();
			int x = now.x;
			int y = now.y;
			int temp = a[x][y];
			if(temp>0&&temp<size) {
				if(check!=true) {
					check = true;
					min_d = dd[x][y];
					u.add(now);
				}
				else if(min_d==dd[x][y]) u.add(now);
			}
			else if(!check) {
				for(int i = 0; i < 4; i++) {
					int xr = x+r[i];
					int yc = y+c[i];
					if(xr>-1&&xr<n&&yc>-1&&yc<n&&!visited[xr][yc]&&a[xr][yc]<=size) {
						dd[xr][yc] = dd[x][y]+1;
						p.add(new Point(xr, yc));
						visited[xr][yc] = true;
					}
				}
			}
		}
		
		if(check) {
			Point nn = u.poll();
			while(!u.isEmpty()) {
				Point nm = u.poll();
				if(nm.x<nn.x) nn = nm;
				else if(nm.x==nn.x&&nn.y>nm.y) nn = nm;
			
			}
			distance += dd[nn.x][nn.y];
			a[nn.x][nn.y] = 0;
			count++;
			shark = nn;
			if(count == size) {
				size++;
				count = 0;
			}
			return true;
		}
		else return false;
	}
}
