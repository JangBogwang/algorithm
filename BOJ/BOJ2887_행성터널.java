package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2887_행성터널 {
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
			int minMST = 0;
			List<Edge> result = new ArrayList<>();
			
			int[] parent = new int[V];
			int[] rank = new int[V];
			
			for(int i = 0; i < V; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			
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
		Graph graph = new Graph(v, 3*(v-1)); 
		int[][] star = new int[v][4];
		StringTokenizer st;

		for(int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][1] = Integer.parseInt(st.nextToken());
			star[i][2] = Integer.parseInt(st.nextToken());
			star[i][3] = Integer.parseInt(st.nextToken());
			star[i][0] = i;
		}
		
		Arrays.sort(star, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
		
		for(int i = 0; i < v -1; i++) {
			graph.addEdge(star[i][0], star[i+1][0], star[i+1][1] - star[i][1]);	
		}
		
		Arrays.sort(star, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
		for(int i = 0; i < v -1; i++) {
			graph.addEdge(star[i][0], star[i+1][0], star[i+1][2] - star[i][2]);	
		}
		Arrays.sort(star, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[3], o2[3]);
            }
        });
		for(int i = 0; i < v -1; i++) {
			graph.addEdge(star[i][0], star[i+1][0], star[i+1][3] - star[i][3]);	
		}
		int result = graph.kruskal();
		System.out.print(result);
	}
}
