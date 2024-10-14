import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		while(pq.size()>1) {
			int temp = pq.poll() + pq.poll();
			pq.add(temp);
			result += temp;
		}

		System.out.print(result);
	}
}
