import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539_사과나무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String result = "YES";
		int[] tree = new int[n];
		int odd = 0;
		int total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			total+=tree[i];
			if((tree[i]&1)==1)
				odd++;
		}
		
		if(total%3!=0)
			result = "NO";
		else {
			int even = (total-odd)/2;
			if(even < odd)
				result = "NO";
			else {
				while(even > odd) {
					even--;
					odd += 2;
				}
				
				if(even != odd)
					result = "NO";
			}
			
		}
		System.out.print(result);
	}
}
