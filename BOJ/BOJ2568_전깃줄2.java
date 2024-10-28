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
		int[][] line = new int[n][2];
		int[] arr = new int[n];
		int[] record = new int[n]; 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> lis = new ArrayList<>();
		Arrays.sort(line, Comparator.comparingInt(o->o[1]));
		for(int i = 0; i < n; i++) 
			arr[i] = line[i][0];
		
		for (int num : arr) {
	        int pos = Collections.binarySearch(lis, num);
	        if (pos < 0) pos = -(pos + 1);
	        if (pos == lis.size()) {
	            lis.add(num);
	        } else {
	            lis.set(pos, num);
	        }
	    }
		
	}
	
}
