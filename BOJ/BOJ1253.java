import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;


public class BOJ1253 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> m = new HashMap<>();
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i <n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(m.get(arr[i])==null)	m.put(arr[i], 1);
			else {
				int j = m.get(arr[i])+1;
				m.put(arr[i], j);
			}
		}
		
		for(int i = 0; i <n-1; i++) {
			for(int j = i+1; j < n; j++) {
				int a = arr[i]+arr[j];
				if(m.get(a)!=null) {
					if(m.get(a)!=0) {
						count += m.get(a);
						m.put(a, 0);
					}
				}
			}
		}
		System.out.print(count);
	}
}