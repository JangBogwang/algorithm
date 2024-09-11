package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4386_별자리만들기 {
	static double[][] star;
	
	static class Edge{
		int src, dest;
		double weight;
		
		Edge(int src, int dest, double weight){
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
		
		void addEdge(int src, int dest, double weight) {
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
		
		double kruskal() {
			double mst = 0;
			List<Edge> result = new ArrayList<>();
			
			Collections.sort(edges, Comparator.comparingDouble(o -> o.weight));
			
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
			
			for(Edge edge: result) {
				mst += edge.weight;
			}
			
			return mst;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		Graph graph = new Graph(v, v * v-1);
		
		star = new double[v][2];  
		
		
		for(int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i = 0; i < v; i++) {
			for(int j = i+1; j < v; j++) {
				double weight = Math.sqrt(Math.pow(star[i][0] - star[j][0], 2)+Math.pow(star[i][1] - star[j][1], 2));
				graph.addEdge(i, j, weight);
			}
		}
		
		double result = graph.kruskal();
		System.out.print(result);
	}
}

