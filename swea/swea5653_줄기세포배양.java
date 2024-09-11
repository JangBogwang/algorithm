import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea5653_줄기세포배양 {
	static int[] r = {-1, 0, 1, 0};
	static int[] c = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			Deque<cell> active = new ArrayDeque<>();
			Deque<cell> inactive = new ArrayDeque<>();
			Map<Point, Integer> map = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++ ) {
					int a  = Integer.parseInt(st2.nextToken());
					if(a != 0) {
						map.put(new Point(i,j), a);
						inactive.add(new cell(i,j,a));
					}
				}
			}
			
			for(int i = 1; i < time; i++) {
				int b = inactive.size();
				int c = active.size();
				for(int j = 0; j < b; j++) {
					cell d = inactive.pollFirst();
					d.life = d.life-1;
					if(d.life == 0) {
						d.life = 
						active.add(d);
					}
					else inactive.add(d);
				}
				
				for(int j = 0; j < c; j++) {
					cell e = active.pollFirst();
					e.life = e.life - 1;
				}
				
			
			}
			

		}
		System.out.print(sb);
		
	}
	

	public static class cell {
		int x;
		int y;
		int life;
		
		cell(int x, int y, int life){
			this.x = x;
			this.y = y;
			this.life = life;
		}
	}
}
