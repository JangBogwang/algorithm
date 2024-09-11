import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ21918 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] in1 = br.readLine().split(" ");
		int n = Integer.parseInt(in1[0]);
		int m = Integer.parseInt(in1[1]);
		String [] in2 = br.readLine().split(" ");
		int[] light = new int[n];
		for(int i = 0; i<n; i++) {
			if(in2[i].equals("1")) {
				light[i] = 1;
			}
		}
		
		for(int i = 0; i < m; i++) {
			String [] in3 = br.readLine().split(" ");
			int a = Integer.parseInt(in3[0]);
			int b = Integer.parseInt(in3[1]);
			int c = Integer.parseInt(in3[2]);
			
			if(a == 1) {
				light[b-1] = c;
			}
			else if(a == 2) {
				for(int j = b-1; j<c; j++) {
					light[j] = light[j]^1;
				}
			}
			else if(a == 3) {
				for(int j = b-1; j<c; j++) {
					light[j] = 0;
				}
			}
			else if(a == 4) {
				for(int j = b-1; j<c; j++) {
					light[j] = 1;
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			sb.append(light[i]+" ");
		}
		System.out.print(sb);
		
	}
}
