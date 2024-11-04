import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2568_전깃줄2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		// 입력 값을 저장 
		int[][] line = new int[n][2];
		// B 기둥에 연결된 A기둥의 번호를 순서대로 저장 
		int[] arr = new int[n];
		
		// 연결 관계 입력 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// B기둥의 위치를 기준으로 정렬 
		Arrays.sort(line, Comparator.comparingInt(o->o[1]));
		for(int i = 0; i < n; i++) 
			arr[i] = line[i][0];
		
		// LIS 를 저장할 List
		int[] lis = new int[n+1];
		// 마지막 인덱스 저장 
		int last_index = 0;
		// 자신 이전 위치의 값을 저장할 배열 
		int[] pre = new int[500001];
		
		// 
		for(int i = 0; i < n; i++) {
			if(arr[i] > lis[last_index]) {
				pre[arr[i]] = lis[last_index++];
				lis[last_index] = arr[i];
			}
			else {
				int l = 1;
				int r = last_index;
				int next=1;
				while(l < r){
					next = (l + r)/2;
					if(lis[next] < arr[i]) {
						l = next+1;
					}else {
						r = next;
					}
				}
				
				lis[next] = arr[i];
				pre[arr[i]] = lis[next-1]; 
			}
		}
		sb.append(n - last_index+"\n");
		int k = last_index;
		while(k>0) {
			lis[k-1] = pre[lis[k]];
			k--;
		}
		k = 1;
		Arrays.sort(arr);
		for(int i = 0; i<n; i++){
			if(arr[i]!=lis[k])
				sb.append(arr[i]+"\n");
			else
				k++;
		}
		
		System.out.print(sb);
	}
	
}
