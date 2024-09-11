import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1940 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr= new int[m];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(str.nextToken());
			if(a<m) arr[a]+=1;
		}
		int result = 0;
		for(int i = 1; i <= (m-1)/2; i++) {
			if(arr[i]>=arr[m-i]) result += arr[m-i];
			else result += arr[i];
		}
		System.out.print(result);
	}
}
