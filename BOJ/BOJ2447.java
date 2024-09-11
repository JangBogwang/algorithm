import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class BOJ2447 {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = 0, temp = n;
		while(temp!=1) {
			temp = temp/3;
			m++;
		}

		String[][] arr = new String[n][n];
		for(int i = 0; i<n;i++) Arrays.fill(arr[i], " ");
		
		star(0,0, m, arr);	

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++ ) sb.append(arr[i][j]);	
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void star(int x, int y,int d, String[][] arr) {
		if(d==0) {
			arr[x][y] = "*";
			return;
		}
		int a = (int)Math.pow(3, d-1);
		star(x,y,d-1,arr);
		star(x+a,y,d-1,arr);
		star(x+2*a,y,d-1,arr);
		star(x,y+a,d-1,arr);
		star(x,y+2*a,d-1,arr);
		star(x+a,y+2*a,d-1,arr);
		star(x+2*a,y+a,d-1,arr);
		star(x+2*a,y+2*a,d-1,arr);
	}
}
