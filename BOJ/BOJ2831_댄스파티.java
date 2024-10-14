package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 메모리: 42720kb 시간: 732ms 
// 정렬하고 순서대로 매칭시키면 됨. 

public class BOJ2831_댄스파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer> mb = new ArrayList<>(); // 작은 거 선호 남자 
		List<Integer> ms = new ArrayList<>(); // 큰 거 선호 남자 
		List<Integer> wb = new ArrayList<>(); // 큰 거 선호 여
		List<Integer> ws = new ArrayList<>(); // 작은 거 선호 여자 
		
		// 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int height = Integer.parseInt(st.nextToken());
			if(height < 0)
				ms.add(-height);
			else
				mb.add(height);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int height = Integer.parseInt(st.nextToken());
			if(height < 0)
				ws.add(-height);
			else
				wb.add(height);
		}
		
		// 모든 리스트 정렬 
		Collections.sort(ms);
		Collections.sort(mb);
		Collections.sort(ws);
		Collections.sort(wb);
		
		int count = 0;
		int im = 0; // 남성 리스트 index
		int iw = 0; // 여성 리스트 index
		while(ms.size()>im && iw < wb.size()) {
			int mm = ms.get(im);
			int ww = wb.get(iw);
			// 크기 비교 후 취향이 맞으면 쌍 만들어진다. 
			if(ww < mm) {
				count++;
				im++;
				iw++;
			}
			// 아니면 그냥 index만 증가 
			else {
				im++;
			}
		}
		
		im = 0; // 남성 리스트 index
		iw = 0; // 여성 리스트 index
		while(mb.size()>im && iw < ws.size()) {
			int mm = mb.get(im);
			int ww = ws.get(iw);
			if(ww > mm) {
				count++;
				im++;
				iw++;
			}
			else {
				iw++;
			}
		}
		
		System.out.print(count);
		
	}
}
