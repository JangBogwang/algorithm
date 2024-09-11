import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ14502 {
	static int n;
	static int m;
	static List<Point> virus = new ArrayList<>();
	static List<Point> blank = new ArrayList<>();
	static int[][] arr;
	static int min;
	static int blank_size;
	static int[] r = {1, 0, -1, 0, 1, -1, 1, -1};
	static int[] c = {0, 1, 0, -1, 1, 1, -1, -1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str  = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int[n][m];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) virus.add(new Point(i,j));
				if(arr[i][j]==0) blank.add(new Point(i,j));
 			}
		}
		
		blank_size = blank.size();
		combination(0, 0);
		System.out.print(blank_size-min-3);
	}
	
	public static void combination(int start, int index){
		if(index==3) {
			check_min();
			return;
		}
		
		for(int i = start; i < blank_size; i++) {
			Point a = blank.get(i);
			int x = a.x;
			int y = a.y;
			arr[x][y]=1;
			combination(i+1, index+1);
			arr[x][y]=0;
		}
		
	}
	
	public static void check_min() {
		int[][] arr2 = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		
		int count = 0;
		for(int i = 0; i < virus.size(); i++) {
			Point a = virus.get(i);
			Queue<Point> q = new LinkedList<>();
			q.add(a);
			while(!(q.isEmpty())) {
				Point b = q.poll();
				for(int j = 0; j < 4; j++) {
					int xr = b.x+r[j];
					int yc = b.y+c[j];
					if((xr>-1)&&(xr<n)&&(yc>-1)&&(yc<m)) {
						if(arr2[xr][yc]==0) {
							arr2[xr][yc] = 2;
							count++;
							q.add(new Point(xr,yc));
						}
					}
				}
			}
		}
		if(count<min) min = count;
	}
}
