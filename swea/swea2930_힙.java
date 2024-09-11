import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2930_힙 {
	static int[] a;
	static int heap_size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			a = new int[n+1];
			heap_size = 0;
			sb.append("#"+t+" ");
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken());
				if(b == 1) {
					int c = Integer.parseInt(st.nextToken());
					insert_heap(c);
				}
				else {
					int c = -1;
					if(heap_size != 0) {
						c = delete_heap();
					}
					sb.append(c+" ");
				}				
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void insert_heap(int num) {
		heap_size++;
		a[heap_size] = num;
		int now = heap_size;
		
		while(a[now/2] < a[now] && now!=1) {
			int temp = a[now/2];
			a[now/2] = a[now];
			a[now] = temp;
			now = now/2;
		}
	}
	
	static int delete_heap() {
		int r = a[1];
		a[1] = a[heap_size];
		heap_size--;
		int now = 1;
		int p = 0;
		while(now != p) {
			p = now;
			int next = now;
			if(now*2+1 <= heap_size&&now*2<= heap_size&&a[now*2] < a[now*2+1] && now*2+1 <= heap_size)next = now*2+1; 
			else next = now*2;
			if(next <= heap_size&&a[now] < a[next]) {
				int temp = a[next];
				a[next] = a[now];
				a[now] = temp;
				now = next;
			}
		}
		return r;
	}
		
}
