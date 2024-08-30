package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주요 아이디어: 배열이 이전 요소까지 합계를 구한 뒤 이를 활용하여 어획량을 구한다.  

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] a = new int[n][n]; // 각 지점까지의 합계를 저장하는 배열 
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j = 0; j < n; j++) {
					sum += Integer.parseInt(st.nextToken());
					a[i][j] = sum; 
					if(i > 0) a[i][j] += a[i-1][j];// 만약 0 이상일 경우 위에 있는 공간의 어획량을 더해준다. 
				}
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int sum = 0;
					int x = i+m-1;// 그물 끝 지점
					int y = j+m-1;// 그물 끝 지점 
					
					// 배열 범위를 벗어날 경우 값 재할당
					if(x >= n) x = n - 1;  
					if(y >= n) y = n - 1;
					
					sum += a[x][y]; // 합계를 더한다. 
					// 조건에 따른 나머지 연산 
					if(i > 0) sum -= a[i-1][y];
					if(j > 0) sum -= a[x][j-1];
					if(i > 0&&j > 0) sum += a[i - 1][j - 1];
					
					// 최댓값보다 클 경우 최댓값 갱신 
					max = Math.max(sum, max);
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.print(sb);
	}
}

