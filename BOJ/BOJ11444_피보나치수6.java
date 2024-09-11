package algorithm;

import java.util.Scanner;

public class BOJ11444_피보나치수6 {
	static long[][] fibo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		StringBuilder sb = new StringBuilder();
		
		fibo = new long[2][2];
		fibo[0][0] = 1;
		fibo[0][1] = 1;
		fibo[1][0] = 1;
		fibo[1][1] = 0;
		
		f(n-1);
		
		System.out.print(fibo[1][0]);
	}
	
	static void f(long n) {
		long[][] fibo2 = new long[2][2];
		fibo2[0][0] = 1;
		fibo2[0][1] = 1;
		fibo2[1][0] = 1;
		fibo2[1][1] = 0;
		long num = 1;
		while(num*2 < n) {
			fibo2 = mult(fibo2, fibo2);
			num*=2;
		}
		n -= num;
		fibo = mult(fibo, fibo2);
		if(n > 0)
			f(n);
	}
	
	static long[][] mult(long[][] A, long[][] B) {
		long[][] C = new long[2][2];
		C[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0])%1000000007;
		C[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1])%1000000007;
		C[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0])%1000000007;
		C[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1])%1000000007;
		return C;
	}
	
}
