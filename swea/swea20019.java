import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea20019 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <=T; t++) {
			String str = br.readLine();
			int n = str.length();
			int n2 = (n-1)/2;
			char[] arr = new char[n];
			
			for(int i = 0; i<n; i++) arr[i] = str.charAt(i);
			
			boolean x = true;
			for(int i = 0; i<n2; i++) {
				if(arr[i]!=arr[n-1-i]) {
					x = false;
					break;
				}
			}
			for(int i = 0; i<n2/2; i++) {
				if(arr[i]!=arr[n2-1-i]) {
					x = false;
					break;
				}
			}
			
			if(x) sb.append("#"+t+" YES\n");
			else sb.append("#"+t+" NO\n");
		}
		System.out.print(sb);
	}

}