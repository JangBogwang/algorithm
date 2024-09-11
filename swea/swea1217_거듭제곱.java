package algorithm;

import java.util.Scanner;

public class swea1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int result = pow(b,c);
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
	
	static int pow(int a, int b) {
		if(b > 1) {
			return a * pow(a,b-1);
		}
		else return a;
	}
}
