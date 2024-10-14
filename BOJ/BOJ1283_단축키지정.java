package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리: 14504kb, 시간: 116ms;

public class BOJ1283_단축키지정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		char[] a;
		boolean[] key = new boolean[26];
		
		for(int i = 0; i < n; i++) {
			a = br.readLine().toCharArray();
			int x = a[0] - 'A';
			if(x  > 26) {
				x = a[0] - 'a';
			}
			int l = Integer.MAX_VALUE;
			if(!key[x]) {
				l = 0;
				key[x] = true;
			}else {
				for(int j = 1; j < a.length; j++) {
					if(a[j]==' ') {
						int y = a[j+1] - 'A';
						if(y > 26) {
							y = a[j+1] - 'a';
						}
						if(!key[y]) {
							l = j+1;
							key[y] = true;
							break;
						}
					}
				}
				
				if(l == Integer.MAX_VALUE) {
					for(int j = 1; j < a.length; j++) {
						if(a[j]==' ') {
							j++;
						}else {
							int y = a[j] -'a';
							if(y < 0) {
								y = a[j] -'A';
							}
							if(!key[y]) {
								l = j;
								key[y] = true;
								break;
							}
						}
					}	
				}
			}
			
			for(int j = 0; j < a.length; j++) {
				if(j == l) {
					sb.append("["+a[j]+"]");
				}else
					sb.append(a[j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
