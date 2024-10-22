import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565_전깃줄 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		StringTokenizer st;
		int[][] line = new int[n][2];
		int[] length = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line, Comparator.comparingInt(o->o[0]));
		
		for(int i = 0; i < n; i++) {
			length[i] = 1;
			for(int j = 0; j < i; j++) {
				if(line[j][0] < line[i][0] && line[j][1] < line[i][1] & length[j]+1 > length[i]) {
					length[i] = length[j]+1;
				}
			}
			if(length[i] > max)
				max = length[i];
		}
		
		System.out.print(n-max);
	}
}
