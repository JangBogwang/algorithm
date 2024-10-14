package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리: 14240kb, 시간: 104ms
// A와 B 사이의 기울기를 계산 
// 둘 사이의 기울기 최대값을 갱신해가며 기울기 최댓값보다 큰 게 있으면 
// 볼 수 있는 건물이 하나 늘어나는 것. 
public class BOJ1027_고층건물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		// i는 현재 내가 있는 건물 
		for(int i = 0; i < n; i++) {
			int count = 0;
			double dd = Integer.MAX_VALUE;
			// 나 기준 왼쪽 건물 검사 
			for(int j = i-1; j > -1; j--) {
				double d = (double)(a[i] - a[j])/(i-j);
				
				if(d < dd) {
					count++;
					dd = d; 
				}
			}
			
			// 오른쪽 건물 검사 
			dd = Integer.MAX_VALUE;
			for(int j = i+1; j < n; j++) {
				double d = (double)(a[i] - a[j])/(j - i);
				
				if(d < dd) {
					count++;
					dd = d; 
				}
			}
			
			if(count > result)
				result = count;
		}
		System.out.print(result);
	}
}
