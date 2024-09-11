import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ10986 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		long sum = 0;
		int z = 0;
		int[] rarr = new int[M];
		int[] zarr = new int[M];
		
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			sum += a;
			if(sum!=0){
				int temp = (int)(sum%M);
				if(a==0) {
					zarr[temp]++;
				}
				rarr[temp]++;
			}
			else z++;
		}
		
		long result = rarr[0]*(z+1);
		
		for(int i = 0; i<M; i++) {
			result += (rarr[i]*(rarr[i]-1))/2 - zarr[i];	
		}
		System.out.print(result);
	}
}