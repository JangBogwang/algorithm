import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ소수경로_1963 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		boolean[] num = new boolean[10000];
		for(int i = 2; i <= 4999; i++) {
			int s = i;
			if(num[i]) continue;
			while(s < 10000) {
				if(s!=i) {
					num[s] = true;
				}
				s += i;
			}
		}
		
		List<Integer> al = new ArrayList<>();
		for(int i = 1000; i < 10000; i++) 
			if(!num[i]) al.add(i);
		
		int l = al.size();
		
		List<Integer>[] al3 = new ArrayList[l];
		for(int i = 0; i < l; i++)
			al3[i] = new ArrayList<>();
		
		for(int i = 0; i < l-1; i++) {
			for(int j = i+1; j < l; j++) {	
				if(vs(al.get(i), al.get(j))) {
					al3[i].add(j);
					al3[j].add(i);
				}
			}
		}
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int s2 = -1, e2 = -1;
			boolean[] visited = new boolean[l];
			for(int i =0; i < l; i++) {
				if(al.get(i)==s) s2 = i;
				if(al.get(i)==e) e2 = i;
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {s2, 0});
			visited[s2] = true;
			int result = -1;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				if(now[0]==e2) {
					result = now[1];
					break;
				}
				for(int next: al3[now[0]]) {
					if(!visited[next]) {
						q.add(new int[] {next, now[1]+1});
						visited[next] = true;
					}
				}
			}
			if(result == -1) sb.append("Impossible\n");
			else sb.append(result+"\n");
		}
		System.out.print(sb);
		
	}
	
	static boolean vs(int a, int b) {
		boolean result = false;
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int x = a%10;
			int y = b%10;
			if(x==y) count++;
			a /= 10;
			b /= 10;
		}
		if(count == 3) result = true;
		return result;
	}
}
