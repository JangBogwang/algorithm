import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1022_소용돌이예쁘게출력하기 {
	static int[][] b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		int[] a = new int[4];
		a[0] = Integer.parseInt(str[0]);
		a[1] = Integer.parseInt(str[1]);
		a[2] = Integer.parseInt(str[2]);
		a[3] = Integer.parseInt(str[3]);
		int[] r = {0, -1, 0, 1};
		int[] c = {-1, 0, 1, 0};
		
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 4; i++) {
			if(max < Math.abs(a[i])) max = Math.abs(a[i]);
		}
		
		int l = max*2+1;
		if( l < 5000) {
			b = new int[l][l];
			int x = l-1;
			int y = l-1;
			int d = 0; 
			for(int i = l*l; i >0; i--) {
				b[x][y] = i;
				int xr = x + r[d];
				int yc = y + c[d];
				if(xr<0||xr>=l||yc<0||yc>=l||b[xr][yc]!=0) {
					if(d < 3) d++;
					else d = 0;
				}
				
				x = x+r[d];
				y = y+c[d];
			}
			
			for(int i = 0; i < 4; i++) {
				a[i] += max;
			}
			
			
			int o = b[a[0]][a[1]];
			int o2 = b[a[2]][a[3]];
			if(o2 > o) o = o2;
			String str2 = String.valueOf(o);
			int len = str2.length();
			for(int i = a[0]; i <= a[2]; i++) {
				for(int j = a[1]; j <= a[3]; j++) {
					String str3 = String.valueOf(b[i][j]);
					int len2 = str3.length();
					if(len2!=len) {
						for(int k = 0; k < len - len2; k++) {
							sb.append(" ");
						}
					}
					sb.append(str3+" ");
				}
				sb.append("\n");
			}
		}
		else {
			int x_l = Math.abs(a[0] - a[2]);
			int y_l = Math.abs(a[1] - a[3]);
			int min = Integer.MAX_VALUE;
			for(int i = 0; i <4; i++) {
				if(min > Math.abs(a[i])) min = Math.abs(a[i]);
			}
			b = new int[x_l+1][y_l+1];
		
			for(int i = min; i <= max; i++) {
				int d = 0;
				int x = i;
				int y = i;
				for(int j = (2*i+1)*(2*i+1); j > (2*i-1)*(2*i-1); j--) {
					if(x<=a[2]&&x>=a[0]&&y<=a[3]&&y>=a[1]) {
						int t1 = a[0];
						int t2 = a[1];
						b[x-t1][y-t2] = j;
					}
					int xr = x + r[d];
					int yc = y + c[d];
					if(Math.abs(xr)>i||Math.abs(yc)>i) {
						d++;
					}
					x = x +r[d];
					y = y +c[d];
				}
			}
			int max2 = 0;
			for(int i = 0; i <= x_l; i++) {
				for(int j = 0; j <= y_l; j++) {
					if(max2<b[i][j]) max2 = b[i][j];
				}
			}
			
			String str2 = String.valueOf(max2);
			int len = str2.length();
			for(int i = 0; i <= x_l; i++) {
				for(int j = 0; j <= y_l; j++) {
					String str3 = String.valueOf(b[i][j]);
					int len2 = str3.length();
					if(len2!=len) {
						for(int k = 0; k < len - len2; k++) {
							sb.append(" ");
						}
					}
					sb.append(str3+" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
