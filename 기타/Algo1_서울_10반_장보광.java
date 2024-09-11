package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1_서울_10반_장보광 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		char[] temp; //  테트리스가 떨어지는 위치를 저장
		int[][] a;// 결과 저장하는 이차원 배열 
		int[] b; // 각 줄에 존재하는 *의 개수 
		
		// 각 테스트 케이스 실행 
		for(int t = 1; t <= T; t++) {
			// 테트리스 크기 
			int n = Integer.parseInt(br.readLine());
			
			// 각 배열 초기화 
			temp = br.readLine().toCharArray();
			a = new int[n][n];
			b = new int[n];
			
			// 별블록 테트리스 시작 
			for(int i = 0; i < temp.length; i++) {
				int now = (int)temp[i] -'0';
				if(b[now]==n) continue;
				else {
					b[now]++;
					if(b[now]==1) {
						int min = Integer.MAX_VALUE;
						for(int j = 0; j < n; j++) {
							if(b[j] < min) min = b[j];
						}
						
						if(min == 1) {
							for(int j = 0; j < n; j++) b[j]--;
						}
					}
				}
			}
			
			sb.append("#"+t+"\n");
			// 결과 저장
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <  n; j++) {
					if(i > n - 1 - b[j]) {
						sb.append("*");
					}
					else sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
