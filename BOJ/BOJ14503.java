import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		String[] str2 = br.readLine().split(" ");
		int x = Integer.parseInt(str2[0]);
		int y = Integer.parseInt(str2[1]);
		int d = Integer.parseInt(str2[2]);
		
		int[] r = {-1, 0, 1, 0};
		int[] c = {0, 1, 0, -1};
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;  j <m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0; 
		Point next = new Point(x,y); 
		while(next!=null) {
			int nx = next.x;
			int ny = next.y;
			
			if(arr[nx][ny] == 0) {
				arr[nx][ny] = 2;
				count++;
			}
			
			boolean check = false; 
			for(int i = 0; i <4 ; i++) {
				int xr = nx+r[i];
				int yc = ny+c[i];
				if(arr[xr][yc]==0) check = true;
			}
			
			if(check) {
				for(int i = 0; i< 4; i++) {
					if(d>0) d--;
					else d=3;
					int xf = nx+r[d];
					int yf = ny+c[d];
					if(arr[xf][yf]==0) {
						next = new Point(xf, yf);
						break;
					}
				}
			}
			else {
				int xb = nx-r[d];
				int yb = ny-c[d];
				if(arr[xb][yb]==1) break;
				else next = new Point(xb,yb);
			}
		}
		
		
		System.out.print(count);
	}
}
