import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1288_새로운불면증치료법 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int a = 0;
			boolean[] b = new boolean[10];
			int i = 1;
			while(a != 10) {
				int num = i * n;
				while(num!=0) {
					int temp = num%10;
					num = num/10;
					if(b[temp]==false) {
						b[temp] = true;
						a++;
					}
				}
				i++;
			}
			sb.append("#"+t+" "+(i-1)*n+"\n");
		}
		System.out.print(sb);
	}
}
