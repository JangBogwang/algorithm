import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7578_공장 {
	static long result;
	static int[] a, temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[1000001];
		a = new int[n];
		temp = new int[n];
		result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			map[num] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			a[i] = map[num];
		}

		merge_sort(0, n-1);
		System.out.print(result);
	}
	
	static void merge_sort(int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			merge_sort(left, mid);
			merge_sort(mid+1, right);	
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int m = mid+1;
		int k = left;
		while(l <= mid && m <= right) {
			if(a[l] <= a[m]) {
				temp[k++] = a[l++];
			}else {
				temp[k++] = a[m++];
				result += (long)(mid - l + 1);
			}
		}
		
		while(l <= mid) temp[k++] = a[l++];
		
		while(m <= right) temp[k++] = a[m++];
		
		for(int i = left; i <= right; i++) a[i] = temp[i];
	}
}
