package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11658_구간합구하기3 {
	static class SegmentTree{
		int[] tree;
		int n;
		
		public SegmentTree(int[] arr) {
			n = arr.length;
			tree = new int[n*2];
			build(arr);
		}
		
		private void build(int[] arr) {
			for(int i = 0; i < n; i++)
				tree[n+i] = arr[i];
			for(int i = n-1; i > 0; --i)
				tree[i] = tree[2*i] + tree[2*i+1];
		}
		
		public int query(int left, int right) {
			int res = 0;
			left += n;
			right += n;
			
			while(left < right) {
				if((left&1)==1)
					res += tree[left++];
				if((right&1)==1)
					res += tree[--right];
				left /= 2;
				right /= 2;
			}
			
			return res;
		}
		
		public void update(int pos, int value) {
			pos += n;
			tree[pos] = value;
			while(pos > 1) {
				pos/=2;
				tree[pos] = tree[2*pos] + tree[2*pos+1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n*n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i*n+j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		SegmentTree seg = new SegmentTree(a);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if(w == 1) {
				int result = 0;
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				for(int j = x1 -1; j < x2; j++) {
					result += seg.query(j*n + y1 -1, j*n + y2);
				}
				sb.append(result+"\n");
				
			}else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				seg.update((x-1)*n+y-1, value);
			}
		}
		System.out.print(sb);
	}
}
