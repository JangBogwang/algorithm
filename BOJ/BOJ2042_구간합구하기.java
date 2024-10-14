package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2042_구간합구하기 {
	
	static class SegmentTree{
		long[] tree;
		int n;
		
		public SegmentTree(long[] arr) {
			n = arr.length;
			tree = new long[2*n];
			build(arr);
		}
		
		// 세그먼트 트리 생성 
		private void build(long[] arr) {
			for(int i = 0; i < n; i++) {
				tree[n+i] = arr[i];
			}
			for(int i = n-1; i > 0; --i) {
				tree[i] = tree[2*i] + tree[2*i+1];
			}
		}
		
		// 구간 합 질의 
		public long query(int left, int right) {
			long res = 0;
			left += n;
			right += n;
			
			while(left < right) {
				if((left&1)==1) 
					res += tree[left++];
				if((right&1) == 1)
					res += tree[--right];
				left/=2;
				right/=2;
			}
			
			return res;
		}
		
		public void update(int pos, long value) {
			pos += n;
			tree[pos] = value;
			while(pos > 1) {
				pos /= 2;
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
		int k = Integer.parseInt(st.nextToken());
		
		long[] a =new long[n];
		for(int i = 0; i < n; i++) 
			a[i] = Long.parseLong(br.readLine());
		
		SegmentTree seg = new SegmentTree(a);
		
		for(int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long z = Long.parseLong(st.nextToken());
			
			if(x==1) {
				seg.update(y-1, z);
			}else {
				long result = seg.query(y-1, (int)z);
				sb.append(result+"\n");
			}
			
		}
		System.out.print(sb);
	}
	
}
