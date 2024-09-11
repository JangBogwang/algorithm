import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea10760_우주선착륙3 {	
	static int[][] a; 
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] r = {1,0,-1,0,1,-1,1,-1};
		int[] c = {0,1,-0,-1,1,1,-1,-1};
		
		
		for(int t=1; t <=T; t++){
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int result = 0;
			
			a = new int[n][m];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<m; j++) a[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int d, x, y;
			
			for(int i=0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(a[i][j]==1) continue;
					d = 0;
					for(int k = 0 ; k<8; k++) {
						if(d>=4) break;
						x = i+r[k];
						y = j+c[k];
						if(x>-1&&x<n&&y>-1&&y<m) {
							if(a[x][y]<a[i][j]) d++;
						}
					}
					if(d>=4) result+=1;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
