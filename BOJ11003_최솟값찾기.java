import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ11003_최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		StringTokenizer str2 = new StringTokenizer(br.readLine()); 
		int [] num = new int[n];
		for(int i = 0; i < n; i++) num[i] = Integer.parseInt(str2.nextToken());
		Deque<Integer> index = new ArrayDeque<>();
		
		int id = 0;
		for(int i=0;i<n; i++) {
			int a = num[i];

			while(!index.isEmpty()&&index.peekFirst()<=i-m)	index.removeFirst();
			
			if(index.isEmpty()) {
				index.add(i);
				sb.append(num[i]+" ");
				continue;
			}
			
			id = index.peekFirst();
			if(a<=num[id]) {
				while(!index.isEmpty()) index.remove();
				index.addFirst(i);
				id = i;
			}
			else{
				while(!index.isEmpty()&&a<=num[index.peekLast()]) index.removeLast();
				index.addLast(i);
			}				
			
			sb.append(num[id]+" ");
		}
		System.out.print(sb);
	}
}
