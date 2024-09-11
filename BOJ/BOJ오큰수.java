import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class BOJ오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		int[] a = new int[n]; 
		int[] r = new int[n];
		int c = 0;
		for(int i=0;i<n;i++) a[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(r, -1);
		
		for(int i = 0; i < n; i++) {
			if(dq.isEmpty()) {
				dq.add(i);
				continue;
			}
			int b = a[i];
			c = dq.peekFirst();
			if(b<=a[c]) dq.addFirst(i);
			else {
				while(a[c]<b) {
					dq.removeFirst();
					r[c] = b;
					if(!dq.isEmpty()) {
						c = dq.peekFirst();
					}
					else break;
				}
				dq.addFirst(i);
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append(r[i]+" ");
		}
		System.out.print(sb);
	}
}
