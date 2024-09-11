import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1209 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int[][] arr2 = new int[2][100];
			int[] arr3 = new int[2];
			int  max = 0;
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr2[0][i] +=arr[i][j];
					arr2[1][j] += arr[i][j];
					if(i==j) arr3[0] += arr[i][j];
					if(i+j==99) arr3[1] += arr[i][j];
				}
			}
			
			if(arr3[0]>max) max = arr3[0];
			if(arr3[1]>max) max = arr3[1];
			
			for(int i = 0; i < 100; i++) {
				if(arr2[0][i]>max) max = arr2[0][i];
				if(arr2[1][i]>max) max = arr2[1][i];
			}
			sb.append("#"+n+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
