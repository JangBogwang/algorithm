package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리: 35560kb 시간: 356ms

public class BOJ13305_주유소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dist = new long[n]; //거리를 저장하는 배열
		long price; // 가격을 저장하는 배열 
		// 결과를 저장하는 변수 
		long result = 0;
		
		// 거리입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n-1; i++) dist[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long min = Integer.MAX_VALUE;
		// 주유비 계산
		for(int i = 0; i < n - 1; i++) {
			price = Integer.parseInt(st.nextToken());
			if(min > price) min = price;
			result += (min * dist[i]);
		}
		
		// 결과 출력 
		System.out.print(result);
		
	}
}
