package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18185_라면사기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		boolean check = true;
		int index = 0;
		int result = 0;
		while(check) {
			while(a[index] > 0) {
				if(index < n -2 && a[index+1]>0&& a[index+2]>0) {
					int min = 1000000;
					for(int i = 0; i < 3; i++) {
						if(min > a[index+i]) min = a[index+i];
					}
					result += min * 7;
					a[index] -= min;
					a[index+1] -= min;
					a[index+2] -= min;
					
				}
				else if(index < n - 1 && a[index+1]>0) {
					int min = 0;
					if(a[index] < a[index + 1]) min = a[index];
					else min = a[index+1];
					result += min * 5;
					a[index] -= min;
					a[index+1] -= min;
				}
				else {
					result += a[index] * 3;
					a[index] = 0;
				}
			}
			if(index == n-1) break;
			index++;
		}
		System.out.print(result);
	}
}
