package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 메모리: 298840KB, 시간: 564ms
// 맞은 개수 (7 / 19)

public class BOJ21278{

	static int N;	// 노드 개수
	static int M;	// 간선 개수
	static int totalDistance;	// 총 거리
	static int distance;	// 단일 거리
	static int indexA;	// 치킨집 index A
	static int indexB; 	// 차킨집 index B
	static Queue<Building> container;	// BFS Container
	
	// Building 객체
	static class Building{
		int data;
		List<Building> neighbors;
		boolean visited;
		
		public Building(int data) {
			this.data = data;
			neighbors = new ArrayList<>();
			visited = false;
		}
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Building[] buildings = new Building[N];
		
		for(int i=0; i<N; i++) {
			buildings[i] = new Building(i+1);
		}
		
		// Input
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			
			buildings[A].neighbors.add(buildings[B]);
			buildings[B].neighbors.add(buildings[A]);
		}
		
		int minTotalDistance = Integer.MAX_VALUE;
		
		// nC2, BFS
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				
				totalDistance = 0;
				
				for(int k=0; k<N; k++) {
					if(k == i || k == j) {
						continue;
					}
					resetVisited(buildings);
					distance = 0;
					
					container = new LinkedList<>();
					container.offer(buildings[k]);
					buildings[k].visited = true;
					
					// 해당 지점에서 BFS를 통해서 치킨집 중 최단거리 찾기
					findDistance(i, j);
					totalDistance += distance * 2;
				}
				
				// 최소 거리
				if(totalDistance < minTotalDistance) {
					minTotalDistance = totalDistance;
					indexA = i + 1;
					indexB = j + 1;
				}
			}
		}
		
		// Output
		System.out.println("indexA : " + indexA);
		System.out.println("indexB : " + indexB);
		System.out.println("minTotalDistance : " + minTotalDistance);
//		System.out.println(indexA + " " + indexB + " " + minTotalDistance);
	}
	
	static void findDistance(int i, int j) {
		if(container.isEmpty()) {
			return;
		}
		
		Building current = container.peek();
		
		for(int m=0; m<current.neighbors.size(); m++) {
			
			// 치킨집 방문하면 return
			if(current.neighbors.get(m).data == i+1 || current.neighbors.get(m).data == j+1) {
				distance += 1;
				return;
			} 
			
			// 방문한 이웃 pass
			if(current.neighbors.get(m).visited) {
				continue;
			}
			
			// 방문 노드 container에 저장
			container.offer(current.neighbors.get(m));
			current.neighbors.get(m).visited = true;
		}
		
		// 지나간 노드 container에서 out
		container.poll();
		distance += 1;
		
		findDistance(i, j);
	}
	
	// 모든 노드 방문 초기화
	static void resetVisited(Building[] buildings) {
		for(int i=0; i<N; i++) {
			buildings[i].visited = false;
		}
	}
}