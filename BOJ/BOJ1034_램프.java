package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//메모리: 14968kb, 시간: 116ms
public class BOJ1034_램프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 전구 상태 저장 
		boolean[][] a = new boolean[n][m];
		int[] light = new int[n];
		for(int i = 0; i < n; i++) {
			char[] b = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(b[j]=='1')
					a[i][j] = true;
				else 
					light[i]++;
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		// 각 행에 자신과 같은 값을 가진 행의 개수 저장 + 켜야되는 전구의 수 
		int[][] b = new int[n][2];
		// 아직 체크 안 된 행 판별 
		boolean[] check = new boolean[n];
		
		// 각 행 별로 자신과 같은 전구 배열을 가진 행의 개수를 찾아낸다. 
		for(int i = 0; i < n; i++) {
			boolean[] c = new boolean[n];
			if(check[i]) continue;
			
			// 자신과 같은 모양을 가진 행 탐색 
			for(int j = 0; j < m; j++) {
				for(int l = 0; l < n; l++) {
					if(a[l][j]!=a[i][j])
						c[l] = true;
				}
			}
			
			// 같은 행의 개수 확인 
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(!c[j]) {
					check[j] = true;
					count++;
				}
			}
			b[i][0] = count;
			b[i][1] = light[i];
		}
		
		int result = 0; 
		
		// 배열이 같은 행의 개수 내림차순으로 정렬   
		Arrays.sort(b, Comparator.comparingInt((int[] x) -> (x[0])).reversed());
		
		// 조건을 확인하면서 넘어가기
		for(int i = 0; i < n; i++) {
			if(b[i][1] > k && b[i][1]!=0 ) continue;
			else if((Math.abs(b[i][1] - k)&1)==1) 
				continue;
			result = b[i][0];
			break;
		}
		System.out.print(result);
	}
}
