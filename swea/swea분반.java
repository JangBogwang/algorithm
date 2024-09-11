import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea분반 {
	static int min_d;
	static int min;
	static int max;
	static int n;
	static int[] a;
	static int[] b;
	static int[] c;
	static int max_size;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			a = new int[n];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st2.nextToken());
			c = new int[3];
			b = new int[100];
			Arrays.sort(a);
			int now = 1; 
			b[0]++;
			max_size = 1;
			while(now < n) {
				if(a[now] == a[now-1]) {
					b[max_size-1]++;
				}
				else {
					b[max_size]++;
					max_size++;
				}
				now++;
			}
			min_d = Integer.MAX_VALUE;
			search(0, 0);
			if(min_d > n) min_d = -1;
			sb.append("#"+t+" "+min_d+"\n");
		}
		System.out.print(sb);
	}

	public static void search(int now, int r) {
		if(max_size==now) {
			int mx = 0;
			int mn = Integer.MAX_VALUE;
			for(int i = 0; i < 3; i++) {
				if(c[i] > mx) mx = c[i];
				if(c[i]< mn) mn = c[i];
				if(c[i] > max||c[i]<min) return;
			}
			if(min_d>mx-mn) min_d = mx-mn;
		}
		else if(r < 3){
			c[r] += b[now];
			if(now < max_size-(2-r)) search(now+1, r); 	
			search(now+1, r+1);
			c[r] -= b[now];
		}
	}
}



