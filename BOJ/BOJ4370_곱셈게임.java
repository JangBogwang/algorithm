package algorithm;

import java.util.Scanner;

public class BOJ4370_곱셈게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String line;

		// 입력을 EOF까지 계속 받는 방법
        while (sc.hasNextLong()) {
            // 읽어들인 줄을 처리
			boolean turn = true;
        	long p = sc.nextLong();
			long test = 1;
			
			while(test < p) {
				if(turn) 
					test*=9;
				else
					test*=2;
				turn = !turn;
			}
			if(turn) 
				sb.append("Donghyuk wins.\n");
			else 
				sb.append("Baekjoon wins.\n");
        }
		
		System.out.print(sb);
	}
}
