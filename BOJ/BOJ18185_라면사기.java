package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18185_라면사기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		int result = 0;
		int length = 2;
		while(length > -1) {
			int x = -1;
			int min = 1000000;
			for(int i = 0; i < n - length; i++) {
				if(length == 2) {
					if(a[i]!=0&&a[i+1]!=0&&a[i+2]!=0) {
						if(x != -1 && a[i] == a[i+2] && a[i] < a[i+1]) continue;
						else {
							x = i;
							min = Math.min(a[i], a[i+1]);
							min = Math.min(min, a[i+2]);
						}
					}
				}
				else{
					if(length == 1 && a[i] != 0 && a[i+1]!=0) {
						x = i;
						min = Math.min(a[i], a[i+1]);
						break;
					}
					else if(length == 0 && a[i] != 0) {
						x = i;
						min = a[i];
						break;
					}
				}
			}
			
			if(x == -1) {
				length--;
				continue;
			}
			else {
				result += min * (2*length+3);
				for(int i = 0; i <= length; i++) {
					a[x+i] -= min;
				}
			}
		}
		System.out.print(result);
	}
}
