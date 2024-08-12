import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		a[0] = -1;
		for(int i = 1; i <= n; i++ ) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		boolean changed = false;
		for(int i = 1; i <= n+1; i++) {
			changed = false;
			for(int j = 1; j <= n-i; j++) {
				if(a[j] > a[j+1]) {
					changed = true;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if(changed == false) {
				sb.append(i+"\n");
				break;
			}
		}

		System.out.print(sb+"\n");
	}
}