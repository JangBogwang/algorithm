import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1210 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100]; 
			int a = 0;
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			int[] arr2 = new int[100];
			for(int i = 0; i < 100; i++) {
				if(arr[0][i] == 1) {
					if(arr[99][i]==2) a =count;
					arr2[count++] = i;
				}
			}
			
			int[] arr3 = new int[count];
			for(int i = 0; i<count;i++) arr3[i] = arr2[i];
			
			for(int i = 98; i > 0; i--) {
				int b = arr3[a];
				if((arr3[a]-1>-1)&&(arr[i][b-1]!=0)) a--;
				if((b+1<99)&&(arr[i][b+1]!=0)) a++;	
			}
			sb.append("#"+n+" "+arr3[a]+"\n");
		}
		System.out.print(sb);
	}
}
