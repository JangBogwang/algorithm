import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13308_주유소 {
	
	static class Node implements Comparable<Node>{
		int index;
		long cost;
		int minFuelCost;
		
		public Node(int index, long cost, int minFuelCost){
			this.index = index;
			this.cost = cost;
			this.minFuelCost = minFuelCost;
		}
		
		@Override
		public int compareTo(Node o){
			return Long.compare(this.cost, o.cost);
		}
	}
	
	static int n, m;
	static int[] oil;
	static long[][] minFuelCost;
	static List<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		oil = new int[n+1];
		minFuelCost = new long[n+1][10001];
		graph = new ArrayList[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
			Arrays.fill(minFuelCost[i], Long.MAX_VALUE);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w, 0));
			graph[v].add(new Node(u, w, 0));
		}
		
		System.out.print(dijkstra(1, n));
	}
	
	static long dijkstra(int s, int e) {
		long result = 0; 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0, oil[s]));
		minFuelCost[s][oil[s]] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.index == e) {
				return now.cost;
			}
			if (now.cost > minFuelCost[now.index][now.minFuelCost]) continue;
			
			for(Node x: graph[now.index]) {
                int nextFuelCost = Math.min(now.minFuelCost, oil[x.index]);
                long nextCost = now.cost + (long) x.cost * now.minFuelCost;
                
                if (nextCost < minFuelCost[x.index][nextFuelCost]) {
                    minFuelCost[x.index][nextFuelCost] = nextCost;
                    pq.add(new Node(x.index, nextCost, nextFuelCost));
                }
			}
		}
		
		return -1;
	}
	
	
}
