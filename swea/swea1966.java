import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1966 {
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t < T+1; t++)
		{
		   sb.append("#"+t+" ");
	       int n = Integer.parseInt(br.readLine());
	       int[] arr = new int[n];
	       String[] str = br.readLine().split(" ");
	       
	       for(int i = 0; i< n; i++) arr[i] = Integer.parseInt(str[i]);
	       
	       merge_sort(arr, 0,n-1);
	       
	       for(int i = 0; i < n; i++) {
	    	   sb.append(arr[i]+" ");
	       }
	       sb.append("\n");

		}
	    System.out.println(sb);
	}
	
	static void merge_sort(int[] arr, int s, int e) {
		int m;
		
		if(s<e) {
			m = (s+e)/2;
			merge_sort(arr, s, m);
			merge_sort(arr, m+1, e);
			merge(arr, s, m, e);
		}
	}
	
	static void merge(int[] arr, int s,int m, int e) {
		int[] sorted = new int[e-s+1];
		int l = s;
		int r = m+1;
		int count = 0;
		while(l<=m&&r<=e) {
			if(arr[l] > arr[r]) sorted[count++] = arr[r++];
			else sorted[count++] = arr[l++];
		}
		if(l <= m) {
			while(l<=m) sorted[count++] = arr[l++];
		}
		else {
			while(r<=e) sorted[count++] = arr[r++];	
		}
		for(int i = 0; i < e-s+1; i++) {
			arr[s+i] = sorted[i];
		}
	}

}
