package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1922_네트워크연결 {
	static class Edge{
		int src, dest, weight;
		
		Edge(int src, int dest, int weight){
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static class Graph{
		int V, E;
		List<Edge> edges = new ArrayList<>();
		
		Graph(int v, int e) {
			this.V = v;
			this.E = e;
		}
		
		void addEdge(int src, int dest, int weight) {
			edges.add(new Edge(src, dest, weight));
		}
		
		int find(int[] parent, int i) {
			if(parent[i]!=i) 
				return find(parent, parent[i]);
			return parent[i];
		}
		
		void union(int[] parent, int[] rank, int x, int y) {
			int rootX = find(parent, x);
			int rootY = find(parent, y);
			
			if(rank[rootX] < rank[rootX]) 
				parent[x] = rootY;
			else if(rank[rootX] > rank[rootX])
				parent[y] = rootX;
			else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
		int kruskal() {
			int minMST = 0;
			List<Edge> result = new ArrayList<>();
			
			int[] parent = new int[V+1];
			int[] rank = new int[V+1];
			
			for(int i = 0; i < V+1; i++) 
				parent[i] = i;
			
			Collections.sort(edges, Comparator.comparingInt(o -> o.weight));
			
			for(Edge now: edges) {
				int rootX = find(parent, now.src);
				int rootY = find(parent, now.dest);
				
				if(rootX != rootY) {
					union(parent, rank, now.src, now.dest);
					result.add(now);
				}
			}
			
			for(Edge edge: result)
				minMST += edge.weight;
			
			return minMST;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		Graph graph = new Graph(v,e); 
		StringTokenizer st;
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.addEdge(src, dest, weight);
		}
		
		int result = graph.kruskal();
		System.out.print(result);
	}
}
