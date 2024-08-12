import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int ro = Integer.parseInt(str[2]);
		
		int[] r = {0, 1, 0, -1};
		int[] c = {1, 0, -1, 0};
		
		
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		for(int i= 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) a[i][j] = Integer.parseInt(st.nextToken());
		}
		int s = 0;
		if(n < m) s = n/2; 
		else s = m/2;
		
		for(int i = 0; i < s; i++) {
			int g = 2*n+2*m-4-8*i;
			int[] f = new int[g];
			int d = 0;
			int x = i;
			int y = i;
			for(int j = 0; j < g; j++) {
				f[j] = a[x][y];
				int xr = x + r[d];
				int yc = y + c[d];
				if(xr<0||xr>=n||yc<0||yc>=m||b[xr][yc]!=0) d++;
				if(j != g-1) {
					x = x+r[d];
					y = y+c[d];
				}
			}
			
			int index = ro%g;
			x = i;
			y = i;
			d = 0;
			for(int j = 0; j < g; j++) {
				b[x][y] = f[index++];
				if(index==g) index = 0;
				int xr = x + r[d];
				int yc = y + c[d];
				if(xr<0||xr>=n||yc<0||yc>=m||b[xr][yc]!=0) d++;
				if(j != g-1) {
					x = x+r[d];
					y = y+c[d];
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) sb.append(b[i][j]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
