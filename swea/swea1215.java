import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1215 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <=10; t++) {
			int n = Integer.parseInt(br.readLine()); 
			int result = 0;
			
			char[][] arr = new char[8][8];
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j = 0; j<8; j++) arr[i][j] = str.charAt(j);
			}
			
			
			for(int i = 0; i< 8; i++) {
				for(int j = n-1;j < 8; j++) {
					boolean check1 = true, check2 = true;
					for(int k = 0; k<n/2; k++) {
						if(arr[i][j-k]!=arr[i][j-n+1+k]) {
							check1 = false;
							break;
						}
					}
					
					for(int k = 0; k<n/2; k++) {
						if(arr[j-k][i]!=arr[j-n+1+k][i]) {
							check2 = false;
							break;
						}
					}
					if(check1) result++;
					if(check2) result++;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
