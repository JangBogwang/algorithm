import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea1873_상호의배틀필드 {
	static char[] e = {'v','>','^','<'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] r = {1,0,-1,0};
		int[] c = {0,1,-0,-1};
		
		
		for(int t=1; t <=T; t++){
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int d = -1, x = 0, y = 0;
			char[][] a = new char[n][m];
			for(int i = 0; i < n;i++) {
				String s2 = br.readLine();
				for(int j = 0; j<m; j++) {
					a[i][j] = s2.charAt(j);
					if(d == -1) {
						if(a[i][j] == e[0]) d = 0;
						else if(a[i][j] == e[1]) d =1;
						else if(a[i][j] == e[2]) d =2;
						else if(a[i][j] == e[3]) d =3;
						if(d!=-1) {
							x = i;
							y = j;
						}
					}
				}
			}
			
			int l = Integer.parseInt(br.readLine());
			char[] b = new char[l];
			String s2 = br.readLine();
			b = s2.toCharArray();
			for(int i = 0; i<l; i++) {
				if(b[i]=='U') d = 2;
				else if(b[i]=='D') d = 0;
				else if(b[i]=='L') d = 3;
				else if(b[i]=='R') d = 1;
				else if(b[i]=='S') {
					int x2 = x;
					int y2 = y;
					while(true) {
						x2 +=r[d];
						y2 +=c[d];
						if(x2<0||x2>n-1||y2<0||y2>m-1) break;
						else if(a[x2][y2]=='*') {
							a[x2][y2]='.';
							break;
						}
						else if(a[x2][y2]=='#') break;
					}
					continue;
				}
				a[x][y] = e[d];
				int x3 = x+r[d];
				int y3 = y+c[d];
				if(x3<0||x3>n-1||y3<0||y3>m-1) continue;
				else if(a[x3][y3]=='.') {
					a[x3][y3]=e[d];
					a[x][y] = '.';
					x = x3;
					y = y3;
				}
			}
			sb.append("#"+t+" ");
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					sb.append(a[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
