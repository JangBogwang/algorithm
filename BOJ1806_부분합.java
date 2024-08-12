import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int n  = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		int[] a = new int[n+1];
		int sum = 0;
		int r = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++){
			sum  += Integer.parseInt(st.nextToken());
			a[i] = sum;
			if(sum>=s&&r==0) r = i;
		}
		
		int c = r;
		
		if(sum>s){
			for(int i=r-1; i > 0; i--) {
				boolean check = false;
				for(int j = i; j<=n; j++) {
					if((a[j]-a[j-i])>=s) {
						check = true;
						c = i; 
						break;
					}
				}
				if(!check) break;
			}
			r = c;
		}
		System.out.print(r);
	}
}
