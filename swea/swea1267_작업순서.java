package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class swea1267_작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<>();
			ArrayList<Integer>[] al = new ArrayList[n+1];
			int[] count = new int[n+1];
			int index = 0;
			int[] result = new int[n];
			for(int i = 0; i <= n; i++)
				al[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				count[b]++;
				al[a].add(b);
			}
			
			for(int i = 1; i <= n; i++) {
				if(count[i]==0) 
					q.add(i);
			}
			
			int time = 0;
			while(!q.isEmpty()) {
				time++;
				int size = q.size();
				for(int i = 0; i < size; i++) {
					int temp = q.poll();
					result[index++] = temp;
					for(int x: al[temp]) {
						count[x]--;
						if(count[x]==0) {
							q.add(x);
						}
					}
					
				}
			}
			
			sb.append("#"+t+" ");
			for(int i = 0; i < n; i++)
				sb.append(result[i]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}