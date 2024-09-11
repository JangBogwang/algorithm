package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge {
    int src, dest, weight;

    // 간선의 시작점, 끝점, 가중치를 초기화하는 생성자
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V, E; // V: 정점의 수, E: 간선의 수
    List<Edge> edges; // 간선 리스트

    // 그래프를 초기화하는 생성자
    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new ArrayList<>();
    }

    // 간선을 그래프에 추가하는 메서드
    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // 유니온-파인드 자료 구조를 사용한 부모 노드 찾기 (Find 연산)
    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    // 두 집합을 합치는 메서드 (Union 연산)
    void union(int parent[], int rank[], int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // 크루스칼 알고리즘으로 최소 신장 트리를 찾는 메서드
    void kruskalMST() {
        // 결과 간선 리스트를 저장할 리스트
        List<Edge> result = new ArrayList<>();

        // 간선들을 가중치 순으로 정렬
        Collections.sort(edges, Comparator.comparingInt(o -> o.weight));

        // 부모와 랭크 배열을 초기화
        int parent[] = new int[V];
        int rank[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int e = 0; // 결과 간선의 수
        int i = 0; // 정렬된 간선의 인덱스
        while (e < V - 1) {
            // 현재 간선을 가져옴
            Edge nextEdge = edges.get(i++);
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // 사이클이 발생하지 않는 경우만 간선을 추가
            if (x != y) {
                result.add(nextEdge);
                union(parent, rank, x, y);
                e++;
            }
        }

        // 최소 신장 트리 출력
        System.out.println("크루스칼 알고리즘으로 찾은 최소 신장 트리:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }
}

// 실행 예제
public class test {
    public static void main(String[] args) {
        int V = 6; // 정점의 수
        int E = 8; // 간선의 수
        Graph graph = new Graph(V, E);

        // 그래프에 간선 추가
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 6);
        graph.addEdge(3, 5, 7);

        // 크루스칼 알고리즘 실행
        graph.kruskalMST();
    }
}