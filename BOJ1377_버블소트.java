import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1377_버블소트 {
	static int[][] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		a = new int[n][2];
		for(int i = 0; i < n; i++ ) {
			a[i][0] = Integer.parseInt(br.readLine());
			a[i][1] = i;
		}

		 Arrays.sort(a, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                return Integer.compare(o1[0], o2[0]); // 첫 번째 값을 기준으로 비교
	            }
	        });
		 
		for(int i = 0; i < n; i++) {
			if(result < a[i][1] - i) result = a[i][1] - i;
		}
		System.out.print((result+1)+"\n");
	}
	

}
