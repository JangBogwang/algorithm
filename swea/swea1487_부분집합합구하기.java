package algorithm;

import java.util.Scanner;

public class swea1487_부분집합합구하기 {
	static int[] a;
	static int n;
	static int s;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			n  = sc.nextInt();
			s = sc.nextInt();
			
			a = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			count = 0;
			
			for(int i = n-1; i > 0; i--) {
				int max = 0;
				int max_index = 0;
				for(int j = 0; j <= i; j++) {
					if(a[j] > max) {
						max_index = j;
						max = a[j];
					}
						
				}
				int temp = a[i];
				a[i] = max;
				a[max_index] = temp;
			}
			search(0, 0);
			System.out.println(count);
		}
	}
	
	static void search(int now, int sum) {
		if(sum == s) {
			count++;
		}
		else if(now < n){
			int temp = a[now];
			if(sum+temp <= s) {
				search(now+1, sum+temp);
				search(now+1, sum);		
			}		
		}
	}
}
