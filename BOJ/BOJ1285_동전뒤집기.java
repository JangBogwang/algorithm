import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1285_동전뒤집기 {
	static int n;
	static int min;
	static int check;
	static int[] map;
	static boolean[] flip;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		map = new int[n];
		flip = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			int x = 0;
			for(int j = 0; j < n; j++) {
				x = x<<1;
				if(temp[j]=='T') x++;
			}
			map[i] = x;
		}
		
		for(int i = 0; i < n; i++) {
			check = check << 1;
			check++;
		}
		f(0);
		System.out.print(min);
	}
	
	static void f(int now) {
		if(now == n) count();
		else {
			f(now+1);
			map[now] = map[now]^check;
			f(now+1);
			map[now] = map[now]^check;
		}
	}
	
	static void count() {
		int count = 0;
		for(int i = 0; i < n; i++) {
			int temp = 0;
			for(int j = 0; j < n; j++) {
				if((map[j]&(1<<i)) > 0) temp++;
			}
			if(temp < n - temp) count += temp;
			else count += n - temp;
		}
		
		if(count < min) min = count;
	}

}
	

