import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1014_컨닝 {
	static int[] r = {-1, -1, 0, 0, 1, 1};
	static int[] c = {-1, 1, -1, 1, -1, 1};
	static int person; 
	static int n;
	static int m;
	static char[][] a;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			
			a = new char[n][m];
			int n_space = 0;
			
			for(int i = 0; i < n; i++) {
				String[] str2 = br.readLine().split("");
				for(int j = 0; j < m; j++) {
					a[i][j] = str2[j].charAt(0);
					if(a[i][j] == '.') n_space++;
				}
			}
			person = 0;
			if(m==1) {
				person = n_space;
			}
			else {
				search(n_space, 0);	
			}
			sb.append(person+"\n");
			
		}	
		System.out.print(sb);
	}
	
	public static void search(int n_space, int d){
		if(n_space<=0) {
			if(d > person) {
				person = d;
			}
			return;
		}
		
		int min = Integer.MAX_VALUE;
		ArrayList<Point> ar= new ArrayList<Point>(); 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j]=='.') {
					int count = 1;
					for(int k = 0; k < 6; k++) {
						int dr = r[k];
						int dc = c[k];
						if(i+dr<n&&i+dr>-1&&j+dc<m&&j+dc>-1) {
							if(a[i+dr][j+dc]=='.') {
								count++;
							}
						}
					}
					if(count < min) {
						ar = new ArrayList<Point>();
						ar.add(new Point(i,j));
						min = count;
					}
					else if(count == min) {
						if((ar.get(0).y&1)!=(j&1)) {
							if(ar.size()<2) {
								ar.add(new Point(i,j));
							}
						}
					}
				}
			}
		}
		 
	
		for(int i = 0; i < ar.size(); i++) {
			Point temp = ar.get(i);
			a[temp.x][temp.y] = 'x';
			boolean[] back = new boolean[6];
			for(int k = 0; k < 6; k++) {
				int dr = r[k];
				int dc = c[k];
				if(temp.x+dr<n&&temp.x+dr>-1&&temp.y+dc<m&&temp.y+dc>-1) {
					if(a[temp.x+dr][temp.y+dc]=='.') {
						a[temp.x+dr][temp.y+dc]='X';
						back[k] = true;
					}
				}
			}
			search(n_space-min, d+1);
			a[temp.x][temp.y] = '.';
			for(int k = 0; k < 6; k++) {
				int dr = r[k];
				int dc = c[k];
				if(temp.x+dr<n&&temp.x+dr>-1&&temp.y+dc<m&&temp.y+dc>-1) {
					if(back[k]) a[temp.x+dr][temp.y+dc]='.';
				}
			}
		}

	}
}