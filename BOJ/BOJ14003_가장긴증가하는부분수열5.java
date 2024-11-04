import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14003_가장긴증가하는부분수열5 {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] index = new int[n];
		int[] lis = new int[n];
		int[] pre = new int[n];
		Arrays.fill(pre, -1);
		int id = 0;
		for(int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(lis, 0, id, arr[i]);
			if(pos >= 0) continue;
			
			pos = -(pos+1);
			lis[pos] = arr[i];
			index[pos] = i;
			if(pos > 0) pre[i] = index[pos-1];
			if(pos == id) id++;
		}
		
		sb.append(id+"\n");
		int now = index[id-1];
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < id; i++) {
			s.add(arr[now]);
			now = pre[now];
		}
		
		while(!s.isEmpty())
			sb.append(s.pop()+" ");
			
		System.out.print(sb);
	}
}
