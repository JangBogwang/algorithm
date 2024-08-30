package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리: 20392kb, 시간: 196ms
public class BOJ2799_블라인드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;
	static StringBuilder sb =  new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		// 문자열 입력을 받는 변수
		char[] char_input;
		// 각 창문에 대한 입력을 받는 변수
		int[][] window = new int[n][m];  
		// 결과를 저장하는 변수
		int[] result = new int[5];  
		
		// 창문에 대한 입력을 받는다. 
		for(int i = 0; i < 5*n+1; i++) {
			// 각 줄을 char 입력으로 받는다. 
			char_input = br.readLine().toCharArray();
			// #으로만 이루어진 줄은 건너뛴다. 
			if(i%5==0) continue;
			
			// 각 줄에 대한 반복
			for(int j = 1; j < 5*m+1; j+=5) {
				// 창문 위치의 x,y 좌표를 구한다. 
				int x = i/5; 
				int y = j/5;
				
				// 만약 *일 경우 윈도우 배열에 값을 추가한다. 
				if(char_input[j]=='*') {
					window[x][y]++;
				}
				
				//각 창문의 마지막 줄에서 *개수에 따라 결과를 저장한다. 
				if(i%5==4) {
					int t = window[x][y];
					result[t]++;
				}	
			}
		}
		
		// 결과 저장 
		// 결과 출력 
		System.out.print(result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4] );
	}
}
