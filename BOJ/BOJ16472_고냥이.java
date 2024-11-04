import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16472_고냥이 {
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		 
		int[] check = new int[26];// 문자열 체크
		int max = 0, s = 0, e = 0, chk = 1;
		check[f(0)]++;
		
		while(e < arr.length-1) {
			check[f(++e)]++;
			if(check[f(e)]==1) {
				chk++;
				while(chk > n) {
					check[f(e)]--;
					if(check[f(e)]==0) chk--;
					s++;
				}
			}
			if(e - s +1 > max) max = e - s +1;
		}
		
		System.out.print(max);
	
	}
	
	static int f(int n) {
		return arr[n] - 'a';
	}
	
}
