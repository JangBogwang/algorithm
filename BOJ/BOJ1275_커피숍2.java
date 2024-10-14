package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1275_커피숍2 {
	
	static class SegmentTree{
		long[] tree;
		int n;
		
		public SegmentTree(int[] arr) {
			n = arr.length;
			tree = new long[n*2];
			build(arr);
		}
		
		private void build(int[] arr) {
			for(int i = 0; i < n; i++) 
				tree[n+i] = arr[i];
			for(int i = n-1; i > 0; --i) 
				tree[i] = tree[i*2] + tree[i*2+1];
		}
		
		public long query(int left, int right) {
			long res = 0;
			left+=n;
			right+=n;
			
			while(left < right) {
				if((left&1)==1)
					res+=tree[left++];
				if((right&1)==1)
					res+=tree[--right];
				left/=2;
				right/=2;
			}
			
			return res;
		}
		
		public void update(int pos, int value) {
			pos += n;
			tree[pos] = value;
			while(pos > 1) {
				pos/=2;
				tree[pos] = tree[pos*2] + tree[pos*2+1];
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		SegmentTree seg = new SegmentTree(a);
		
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long result;
			if (v <= w) 
				result = seg.query(v-1, w);
			else
				result = seg.query(w-1, v);
			sb.append(result+"\n");
			seg.update(x-1, y);
		}
		
		System.out.print(sb);
	}
}
