import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1068_박성원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long under = fact(n);
		
	}
	
	static long fact(long n) {
		if(n == 1)
			return 1l;
		else
			return fact(n-1) * n; 
	}
}
