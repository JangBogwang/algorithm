package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1101_카드정리1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] ll = new ArrayList[n];
		for(int i = 0; i < n; i++)
			ll[i] = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now > 0) 
					ll[i].add(j);
			}
		}
		
		boolean[] check = new boolean[m];
		int result = n;
		for(int i = 0; i < n; i++) {
			if(ll[i].size() < 2) {
				result--;
				if(ll[i].size()==1) {
					int temp = ll[i].get(0);
					if(!check[temp]) 
						check[temp] = true;
					else
						result++;
				}
			}
		}
		result--;
		if(result < 0)
			result = 0;
		System.out.print(result);
	}
}
