import java.util.Arrays;
import java.util.Scanner;

public class BOJ2448 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		int t =  n/3, d = 0, a = 5;
		while((t&1)!=1) {
			t = t/2;
			d++;
		}
		
		for(int i = 0; i < d; i++) a = a*2+1;


		
		char[][] arr = new char[n][a];
		
		for(int i = 0; i<n;i++) Arrays.fill(arr[i], ' ');
		
		re(n-1,0,arr,d, a, n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < a; j++) sb.append(arr[i][j]);
			sb.append("\n");
		}
		
		System.out.print(sb);		
	}
	
	static void re(int x, int y, char[][] arr,int d, int a, int b) {
		if(d <= 0) {
			for(int i = 0; i<5; i++) {
				arr[x][y+i] = '*';
			}
			arr[x-1][y+1] = '*';
			arr[x-1][y+3] = '*';
			arr[x-2][y+2] = '*';
		}
		else {
			int a2 = (a-1)/2;
			int b2 = b/2;
			re(x,y,arr,d-1,a2, b2);
			re(x,y+a2+1,arr,d-1,a2, b2);
			re(x-b2,y+(a2+1)/2,arr,d-1,a2, b2);
		}
	}
}


