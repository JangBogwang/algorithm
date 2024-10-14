package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6549_히스토그램에서가장큰직사각형 {
	static class hist{
		long h;
		int index;
		
		hist(long h, int index){
			this.h = h;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<hist> s;
		long[] a;

		
		int n = Integer.parseInt(br.readLine());
		long max;
		long min = Long.MAX_VALUE;
		a = new long[n+1];
		
		for(int i = 0; i < n; i++) {
			a[i] = Long.parseLong(br.readLine());
			if(a[i] < min) min = a[i];
		}
		max =0;
		s = new Stack<>();  
		s.push(new hist(0,-1));
		
		for(int i = 0; i < n+1; i++) {
			if(s.peek().h <= a[i]) {
				s.push(new hist(a[i],i));
			}
			else if (s.peek().h > a[i]){
				while(s.peek().h > a[i]) {
					hist temp = s.pop();
					long temp2 = temp.h * (i - (s.peek().index+1));
					if(temp2 > max) 
						max = temp2;
				}
				s.push(new hist(a[i], i));
			}
		}
		
		
		long temp2 = n * min;
		if(temp2 > max) 
			max = temp2;
		
		sb.append(max+"\n");

		
		System.out.print(sb);
	}
}
