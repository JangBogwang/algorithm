import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12927_배수스위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i]=='Y') {
				count++;
				int b = (i+1);
				while(b <= a.length) {
					if(a[b-1] == 'Y') a[b-1] = 'N';
					else a[b-1] = 'Y';
					b += (i+1);
				}
			}
		}
		System.out.print(count);
	}
}
