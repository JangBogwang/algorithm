package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166_다각형의면적 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		double[][] map = new double[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
            map[i][0] = Double.parseDouble(st.nextToken());
            map[i][1] = Double.parseDouble(st.nextToken());
		}
		
		double a;
		double b;
		double c;
		double sum = 0;
		for(int i = 0; i < n-1; i++) {
			if(i!=n-1)
				sum+=(map[i][0]+map[i+1][0])*(map[i][1]-map[i+1][1]);
		}
		sum+=(map[n-1][0]+map[0][0])*(map[n-1][1]-map[0][1]);
		sum = Math.abs(sum)/2;
		String result = String.format("%.1f", sum);
		System.out.print(result);
	}
	
}
