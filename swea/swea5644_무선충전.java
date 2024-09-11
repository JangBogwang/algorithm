package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea5644_무선충전 {
	static int time;
	static int bc_count;
	static int[][][] map;
	static int[] a;
	static int[] b;
	static int[] bc;
	static int[] r = {0, -1, 0, 1, 0};
	static int[] c = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			bc_count = Integer.parseInt(st.nextToken());
			map = new int[10][10][bc_count+1];
			a = new int[time];
			b = new int[time];
			bc = new int[bc_count+1];
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < time; i++) a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < time; i++) b[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < bc_count; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				bc[i] = value;
				f(i, x - 1, y - 1, range, value);
			}
			// 테스트 용
			int[][][]map3 = map;
			int[] rest = bc;
			
			int[] a_pos = {0, 0};
			int[] b_pos = {9, 9};
			
			for(int i = 0; i <= time; i++) {
					int[] bc_a = max_bc(a_pos[0], a_pos[1]);
					int[] bc_b = max_bc(b_pos[0], b_pos[1]);
					if(bc_a[0]!=bc_b[0]) {
						result += bc[bc_a[0]];
						result += bc[bc_b[0]];
					}else{
						if(bc[bc_a[1]]==0&&bc[bc_b[1]]==0) {
							result+=bc[bc_a[0]];
						}else if(bc[bc_a[1]] > bc[bc_b[1]]) {
							result += bc[bc_a[0]];
							result += bc[bc_a[1]];
						}else {
							result += bc[bc_b[0]];
							result += bc[bc_b[1]];
						}
					}
					if(i < time) {
					    a_pos[0] += r[a[i]];
					    a_pos[1] += c[a[i]];
					    b_pos[0] += r[b[i]];
					    b_pos[1] += c[b[i]];
					}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
	
	public static int[] max_bc(int x, int y) {
		int[] ra = new int[2];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addLast(bc_count);
		dq.addLast(bc_count);
		for(int i = 0; i < bc_count; i++) {
			if(map[x][y][i]!=0) {
				if(map[x][y][i] >= map[x][y][dq.peekFirst()]) {
					dq.addFirst(i);
					dq.pollLast();
				}else if(map[x][y][i] > map[x][y][dq.peekLast()]) {
					dq.pollLast();
					dq.addLast(i);
				}	
			}
		}
		for(int i = 0; i < 2; i++) ra[i] = dq.pollFirst();
		return ra;
	}
	
	public static void f(int index,int x, int y, int range, int value) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[10][10];
		
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x1 = now[0];
			int y1 = now[1];
			map[x1][y1][index] = value;
			for(int i = 1; i < 5; i++) {
				int xr = x1 + r[i];
				int yc = y1 + c[i];
				if(xr < 10 && xr > -1 && yc < 10 && yc > -1 &&!visited[xr][yc]) {
					if(Math.abs(x - xr)+Math.abs(y - yc) <= range){
						q.add(new int[] {xr, yc});
						visited[xr][yc] = true;	
					}
				}
			}
		}
	}
}
