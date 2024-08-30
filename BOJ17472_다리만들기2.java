package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472_다리만들기2 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] r = {-1, 0, 1, 0};
		int[] c = {0, -1, 0, 1};
		
		
		int[][] a = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) a[i][j] = Integer.parseInt(st.nextToken()); 
		}
		
		int island = 1;
		Queue<int[]> q = new LinkedList<>(); 
		
		// 섬 찾기 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j]==1&&!visited[i][j]) {
					q.add(new int[] {i,j});
					a[i][j] = island;
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int x = temp[0];
						int y = temp[1];
						
						for(int k = 0; k < 4; k++) {
							int xr = x + r[k];
							int yc = y + c[k];
							if(xr > -1 && xr < n && yc > -1 && yc < m && a[xr][yc]==1) {
								if(!visited[xr][yc]) {
									a[xr][yc] = island;
									visited[xr][yc] = true;
									q.add(new int[] {xr, yc});
								}
								
							}
						}
					}
					island++;
				}
			}
		}
		
		ArrayList<edge> e = new ArrayList<>();
		// 다리 찾기 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] > 0) {
					for(int k = 0; k < 4; k++) {
						int length = 0;
						int x = i;
						int y = j;
						while(true) {
							x += r[k];
							y += c[k];
							if(x > -1 && x < n&& y > -1 && y < m) {
								if(a[x][y]==a[i][j]) break;
								else if(a[x][y] > 0 && a[x][y]!=a[i][j]) {
									if(length > 1) {
										e.add(new edge(a[i][j], a[x][y],  length));								
									}
									break;
								}
								length++;
								
							}
							else break;
						}
					}
				}
			}
		}
		Collections.sort(e);
        parent = new int[island];
        for (int i = 1; i < island; i++) parent[i] = i;
        
        int sum =0;
        int count = 0;
		for (edge edge : e) {
			if (union(edge.x, edge.y)) {
				sum += edge.length;
				count++;
			}
		}
        
        if(count == island-2) System.out.print(sum);
        else System.out.print("-1");
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]); 
	}
	
	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
			return true;
		}
		return false;
	}
	
	

	static class edge implements Comparable<edge>{
		int x, y, length;
		
		edge(int x, int y, int length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
		
		@Override
		public int compareTo(edge e) {
	        return this.length - e.length;
		}
	}
}
