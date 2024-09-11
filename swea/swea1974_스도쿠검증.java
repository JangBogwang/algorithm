import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1974_스도쿠검증 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			int[] c = new int[9];
			int[][] b = new int[2][9];
			int[][] d = new int[3][3];
			int f = 1;
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					int a = Integer.parseInt(st.nextToken());
					c[a-1]++;
					b[0][j] += a;
					b[1][i] += a; 
					d[i/3][j/3] += a;
				}
			}
			
			for(int i = 0; i < 9; i++) {
				int x = i/3;
				int y = i%3;
				if(d[x][y]!=45) f = 0;
				if(c[i]!=9) f = 0;
				if(b[1][i]!=45) f = 0;   
				if(b[0][i]!=45) f = 0;   
			}
			sb.append("#"+t+" "+f+"\n");
		}
		System.out.print(sb);
	}
}
