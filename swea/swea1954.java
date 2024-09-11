
import java.util.Scanner;

public class swea1954 {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<T+1; t++) {
			int[] r = {0,1,0,-1 };
			int[] c = {1,0,-1,0 };
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int number = 1;
			arr[0][0] = number;
			int d = 0, x = 0, y= 0;
			for(int i = 0; i < n*n-1; i++) {
				int check = 0;
				if(x+r[d]<n&&x+r[d]>-1&&y+c[d]>-1&&y+c[d]<n) {
					if(arr[x+r[d]][y+c[d]]==0) {
						x = x+r[d];
						y = y+c[d];
						arr[x][y] = ++number;
						check = 1;
					}
				}
				if(check==0) {
					if(d<3) d++;
					else d = 0;
					x = x+r[d];
					y = y+c[d];
					arr[x][y] = ++number;
				}
			}
			sb.append("#"+t+"\n");
			for(int i = 0; i< n; i++) {
				for(int j = 0; j< n; j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.print(sb);
	}
}
