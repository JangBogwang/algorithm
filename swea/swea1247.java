import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1247 {
	
	static int min;
	
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int t = 1; t < T+1; t++)
		{
	       int n = Integer.parseInt(br.readLine());
	       int[][] arr = new int[n+2][2];
	       String[] input = br.readLine().split(" ");
	       for(int i = 0; i< n+2; i++) {
	    	   arr[i][0] = Integer.parseInt(input[2*i]);
	    	   arr[i][1] = Integer.parseInt(input[2*i+1]);
	       }
	       int[][] arr2 = new int[n+2][n+2];
	       
	       for(int i = 0; i < (n+2); i++) {
	    	   for(int j = 0; j<i; j++) {
	    		 int d  = Math.abs(arr[i][0] - arr[j][0])+Math.abs(arr[i][1] - arr[j][1]);
	    		 arr2[i][j] = d;
	    		 arr2[j][i] = d;
	    	   }
	    	   
	       }
	       int[] visited = new int[n+2];
	       min = 10000;
	       dfs(0, arr2, visited,0,0, n+2);
	       sb.append("#"+t+" "+min+"\n");
		}
	    System.out.println(sb);
	}
	
	public static void dfs(int next, int[][] arr2, int[] visited,int sum ,int l, int n) {
		visited[next] = 1;
		if(l== n-2) {
			sum = sum+arr2[next][1];
			if(sum<min) {
				min = sum;
			}
		}
		else {
			for(int i = 2; i < n; i++) {
				if(visited[i]==0) {
					dfs(i, arr2, visited,sum+arr2[next][i] ,l+1, n);
				}
			}			
		}
		
		visited[next]=0;
	}
}
