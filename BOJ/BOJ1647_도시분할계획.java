package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1647_도시분할계획 {
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
		
		Graph(int V, int E){
			this.V = V;
			this.E = E;
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
			
			if(rank[rootX] > rank[rootY])
				parent[rootY] = rootX;
			else if(rank[rootX] < rank[rootY])
				parent[rootX] = rootY;
			else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
		int kruskal() {
			int mst = 0;
			List<Edge> result = new ArrayList<>();
			
			Collections.sort(edges, Comparator.comparingInt(o -> o.weight));
			
			int[] parent = new int[V+1];
			int[] rank = new int[V+1];
			
			for(int i = 0; i < V+1; i++)
				parent[i] = i;
			
			for(Edge edge: edges) {
				int rootX = find(parent, edge.src);
				int rootY = find(parent, edge.dest);
				
				if(rootX!=rootY) {
					union(parent, rank, edge.src, edge.dest);
					result.add(edge);
				}
			}
			
			int max = 0;
			for(Edge edge: result) {
				if(max < edge.weight) max = edge.weight;
				mst += edge.weight;
			}
			
			return mst - max;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		Graph graph = new Graph(v, e);
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.addEdge(s, d, w);
		}
		
		int result = graph.kruskal();
		System.out.print(result);
	}
}
