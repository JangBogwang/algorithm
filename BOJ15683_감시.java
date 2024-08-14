import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683_감시 {
	
	static int[] r = {1, 0, -1, 0};
	static int[] c = {0, 1, 0, -1};
	static int n;
	static int m;
	static int[][] a;
	static ArrayList<Integer[][]> e = new ArrayList<>();
	static int max; 
	static ArrayList<Point> b = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		e.add(new Integer[][]{{0}, {1}, {2},{3}});
		e.add(new Integer[][]{{0, 2}, {1, 3}});
		e.add(new Integer[][]{{0, 1}, {0, 3}, {2, 1},{2, 3}});
		e.add(new Integer[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 3},{1, 2, 3}} );
		e.add(new Integer[][]{{0, 1, 2, 3}});
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		a = new int[n][m];
		int blank = 0;
		max = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 0) blank++;
				else if(a[i][j]!=6&&a[i][j]!=0) b.add(new Point(i,j));
			}
		}
		if(!b.isEmpty()) {
			Point d = b.get(0);
			int f = a[d.x][d.y];
			for(int i = 0; i < e.get(f-1).length; i++) {
				search(d, 0, i, 0);
			}
		}
		System.out.print(blank - max);
	}
	
	public static void search(Point d, int l, int s, int sum) {
		// 해당 위치 변환하기 
		int f = a[d.x][d.y];
		Integer[] h = e.get(f-1)[s];
		int count = 0;
		for(int i = 0; i < h.length; i++) {
			int x = d.x;
			int y = d.y;
			int drd = h[i];
			int dr = r[drd];
			int dc = c[drd];
			while(x+dr<n&&x+dr>-1&&y+dc<m&&y+dc>-1) {
				if(a[x+dr][y+dc]==6) break;
				if(a[x+dr][y+dc]<=0) {
					if(a[x+dr][y+dc]==0) count++;
					a[x+dr][y+dc]--;
				}
				x = x+dr;
				y = y+dc;
			}
		}
		sum += count;
	
		// 다음 것 호출 
		if(l<b.size()-1) {
			Point d1 = b.get(l+1);
			int f1 = a[d1.x][d1.y];
			for(int i = 0; i < e.get(f1-1).length; i++) {
				search(d1, l+1, i, sum);
			}
		}
		else if(sum>max) max = sum;
		
		// 되돌리기
		h = e.get(f-1)[s];
		for(int i = 0; i < h.length; i++) {
			int x = d.x;
			int y = d.y;
			int drd = h[i];
			int dr = r[drd];
			int dc = c[drd];
			while(x+dr<n&&x+dr>-1&&y+dc<m&&y+dc>-1) {
				if(a[x+dr][y+dc]==6) break;
				if(a[x+dr][y+dc]<0) a[x+dr][y+dc]++;
				x = x+dr;
				y = y+dc;
			}
		}
	}
}
