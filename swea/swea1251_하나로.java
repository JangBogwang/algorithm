package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class swea1251_하나로 {
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
		
		Graph(int v, int e){
			this.V = v;
			this.E = e;
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
			double MST = 0;
			List<Edge> result = new ArrayList<>();
			
			int[] parent = new int[V];
			int[] rank = new int[V];
			
			for(int i = 0; i < V; i++)
				parent[i] = i;
			
			Collections.sort(edges, Comparator.comparingDouble(o -> o.weight));
			int index = 0;
			while(result.size() < V-1) {
				Edge now = edges.get(index++);
				int rootX = find(parent, now.dest);
				int rootY = find(parent, now.src);
				if(rootX != rootY) {
					union(parent, rank, now.src, now.dest);
					result.add(now);
				}
			}
			
			for(Edge edge: result) {
				MST += edge.weight;
			}
			return MST;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] ilands = new int[n][2];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					ilands[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			double ee = Double.parseDouble(br.readLine());
			
			Graph graph = new Graph(n, n*n);
			
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					double weight = ee*((double)(ilands[i][0] - ilands[j][0])*(ilands[i][0] - ilands[j][0]) + (double)(ilands[i][1] - ilands[j][1])*(ilands[i][1] - ilands[j][1]));
					graph.addEdge(i, j, weight);
				}
			}
			
			double result = graph.kruskal();
			sb.append("#"+t+" "+String.format("%.0f", result)+"\n");
		}
		System.out.print(sb);
	}
}
