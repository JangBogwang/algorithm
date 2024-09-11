import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		int[] arr =  new int[w];
		
		StringTokenizer str2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(str2.nextToken());
		}
		int sum = 0;
		for(int i = 1; i<h+1; i++) {
			int st = 0;
			int count = 0;
			for(int j = 0; j < w; j++) {
				if(arr[j]>=i&&st==0) st = 1;
				else if(st==1&&arr[j]>=i) {
					sum+=count;
					count = 0;}
				else if(st==1&&arr[j]<i) count++;
			}
		}
		System.out.print(sum);
	}
}
