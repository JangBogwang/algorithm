package algorithm;

import java.io.*;
import java.util.*;
//메모리: 15700kb 시간: 144ms;

public class BOJ1004_어린왕자 {
	public static void main(String[] args) throws IOException {
		// 변수 및 입출력 선언 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] x = new int[2];
		int[] y = new int[2];
		int[] p = new int[3];
	
		for(int t = 1; t <= T; t++) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			// 출발 지점과 도착 지점 입력
			for(int i = 0; i < 2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			int n = Integer.parseInt(br.readLine());
			// 각 행성계를 입력받는다. 
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int[] c = new int[2];
				for(int j = 0; j < 3; j++) p[j] = Integer.parseInt(st.nextToken());
				for(int j = 0; j < 2; j++) {
					int a = (p[0] - x[j]);
					int b = (p[1] - y[j]);	
					if(a*a+b*b < p[2]*p[2]) c[j] = 1;
				}
				count+= (c[0] ^ c[1]);
			}
			
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
