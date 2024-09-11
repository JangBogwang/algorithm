package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ1197_최소스패닝트리 {
	static class Edge{
		// 시작, 끝 가중치 
		int src, dest, weight;
		
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static class Graph{
		// 정점과 간선의 수를 저장 
		int V, E;
		List<Edge> edges;
		
		// 그래프를 생성하는 함수 
		Graph(int v, int e){
			V = v;
			E = e;
			edges = new ArrayList<>();
		}
		
		void addEdge(int src, int dest, int weight) {
			edges.add(new Edge(src, dest, weight));
		}
		
		int find(int parent[], int i) {
			if(parent[i] == i) return i;
			return find(parent, parent[i]);
		}
		
		void union(int parent[], int rank[], int x, int y) {
			int rootX = find(parent, x);
			int rootY = find(parent, y);
			
			if(rank[rootX] < rank[rootY])
				parent[rootX] = rootY;
			else if(rank[rootX] > rank[rootY]) 
				parent[rootY] = rootX;
			else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
		int kruskal() {
			int count = 0;
			List<Edge> result = new ArrayList<>();
			Collections.sort(edges, Comparator.comparingInt(o -> o.weight));
			
			int parent[] = new int[V];
			int rank[] = new int[V];
			for(int i = 0; i < V; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			
			int e = 0; 
			int i = 0;
			while( e < V - 2) {
	            Edge nextEdge = edges.get(i++);
	            int x = find(parent, nextEdge.src);
	            int y = find(parent, nextEdge.dest);

	            if (x != y) {
	                result.add(nextEdge);
	                union(parent, rank, x, y);
	                e++;
	            }
			}
			
	        for (Edge edge : result) {
	           count += edge.weight;
	        }
			
			return count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		Graph graph = new Graph(v+1,e+1);
		
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
