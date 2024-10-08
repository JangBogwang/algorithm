import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1517_버블소트 {
	static int[][] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		a = new int[n][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++ ) {
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = i;
		}

		 Arrays.sort(a, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                return Integer.compare(o1[0], o2[0]); // 첫 번째 값을 기준으로 비교
	            }
	        });
		 
		for(int i = 0; i < n; i++) {
			result += Math.abs(a[i][1] - i);
		}
		System.out.print((result/2+1)+"\n");
	}
}