package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_최단경로 {
	static ArrayList<int[]>[] graph;
	static int v;
	static int e;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(br.readLine());
		graph = new ArrayList[v+1];
		for (int i = 0; i <= v; i++) graph[i] = new ArrayList<>();
		
		distance = new int[v+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[]{b, c});
		}
		
		search(start);
		
		for(int i = 1; i < v+1; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(distance[i]+"\n");	
			}
		}
		System.out.print(sb);	
	}
	
	  static void search(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int d = current[1];
            
            if(distance[now] < d) continue;
            
            for(int[] neighbor : graph[now]) {
                int next = neighbor[0];
                int weight = neighbor[1];
                
                if(distance[next] > d + weight) {
                    distance[next] = d + weight;
                    pq.add(new int[]{next, distance[next]});
                }
            }
        
        }
	  }
}


