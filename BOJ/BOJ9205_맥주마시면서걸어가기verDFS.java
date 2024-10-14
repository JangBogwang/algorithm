package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9205_맥주마시면서걸어가기verDFS {
	static class point{
		int x;
		int y;
		
		point(int x, int y){
			this.x = x;
			this.y = y;
		}

		point() {
			this.x = 0;
			this.y = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			String result = "sad\n";
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			point start = new point();
			start.x = Integer.parseInt(st.nextToken());
			start.y = Integer.parseInt(st.nextToken());
			point[] con = new point[n+1];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				con[i] = new point();
				con[i].x = Integer.parseInt(st.nextToken());
				con[i].y = Integer.parseInt(st.nextToken());
			}
			
			point end = new point();
			st = new StringTokenizer(br.readLine());
			end.x = Integer.parseInt(st.nextToken());
			end.y = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[n];
			Stack<point> q = new Stack<>();
			q.add(start);
			while(!q.isEmpty()) {
				point now = q.pop();
				if(check(now, end)) {
					result = "happy\n";
					break;
				}
				
				for(int i = 0; i < n; i++) {
					if(!visited[i]&&check(now, con[i])) {
						visited[i] = true;
						q.add(con[i]);
					}
				}
			}
			
			sb.append(result);
		}
		System.out.print(sb);
	}
	
	static boolean check(point p1, point p2){
		if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y) > 1000)
			return false;
		else 
			return true;
	}
}
