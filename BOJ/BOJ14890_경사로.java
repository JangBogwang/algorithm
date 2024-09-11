import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ14890_경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int l = Integer.parseInt(s[1]);
		
		int[][] a =  new int[n][n];
		int[][] c =  new int[n][n];
		int[][] d =  new int[n][n];
		
		boolean[][] b = new boolean[2][n];
		for(int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j<n; j++) {
				if(Math.abs(a[i][j]-a[i][j-1])>1) b[0][i] = true;
				else if(a[i][j]-a[i][j-1]==-1) {
					for(int k = 0; k<l; k++) {
						if(j+k<n){
							if(a[i][j] == a[i][j+k]) c[i][j+k] =1;
							else b[0][i] = true;
						}
						else b[0][i] = true;
					}
				}
				else if(a[i][j]-a[i][j-1]==1){
					for(int k = 0; k<l; k++) {
						if(j-1-k>-1) {
							if((a[i][j-1]!=a[i][j-1-k])||(c[i][j-1-k]==1)) {
								b[0][i] = true;
							}
						}
						else b[0][i] = true;

					}
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			for(int i = 1; i<n; i++) {
				if(Math.abs(a[i][j]-a[i-1][j])>1) b[1][j] = true;
				else if(a[i][j]-a[i-1][j]==-1) {
					for(int k = 0; k<l; k++) {
						if(i+k<n) {
							if(a[i][j] == a[i+k][j]) d[i+k][j] =1;
							else b[1][j] = true;
						}
						else b[1][j] = true;
					}
				}
				else if(a[i][j]-a[i-1][j]==1){
					for(int k = 0; k<l; k++) {
						if(i-1-k>-1) {
							if(a[i-1][j]!=a[i-1-k][j]||d[i-1-k][j]==1) {
								b[1][j] = true;
							}
						}
						else b[1][j] = true;

					}
				}
			}
		}
		int r = 0;
		for(int i =0; i <2; i++) {
			for(int j = 0; j<n;j++) {
				if(!b[i][j]) r++;
			}
		}
		System.out.print(r);
	}
}
