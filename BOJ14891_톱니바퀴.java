import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ14891_톱니바퀴 {
	
	static int[][] a;
	static int[] point = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < 8; j++) a[i][j] = Integer.parseInt(str[j]);
		}
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <n; i++ ) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			rotate(x,y, true, true);
		}
		int sum = 0;
		int d = 1;
		for(int i = 0; i< 4; i++) {
			int now = point[i];
			sum+=a[i][now]*d;
			d*=2;
		}
		System.out.print(sum);	
	}
	
	public static void rotate(int x, int d, boolean r, boolean l) {
		int now = point[x-1];
		if(x < 4 && r) {
			int right = (now+2)%8;
			int left = (point[x]+6)%8;
			if(a[x-1][right] != a[x][left]) rotate(x+1,-d, true, false);
		}
		if(x > 1 && l) {
			int right = (point[x-2]+2)%8;
			int left = (now+6)%8;
			if(a[x-2][right] != a[x-1][left]) rotate(x-1,-d, false, true);
		}
		point[x-1] = (now-d+8)%8; 
	}
}
