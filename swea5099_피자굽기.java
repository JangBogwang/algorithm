import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea5099_피자굽기 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++)
        {
        	String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m  = Integer.parseInt(str[1]);
            
        	int[][] a = new int[n][2];
        	int[] b = new int[m];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<m; i++) b[i] = Integer.parseInt(st.nextToken());
        	
        	for(int i = 0; i<n; i++) {
        		a[i][0] = -1;
        		a[i][1] = -1;
        	}
        	
        	int index = 0;
        	int now = 0;
        	int last = -1;
        	int count = 0;
        	while(true) {
        		if(a[now][0] == -1||a[now][1] == 0) {
        			if(a[now][1] == 0) {
        				last = a[now][0]; 
        				a[now][0] = -1;
        				a[now][1] = -2;
        				count++;
        			}
        			if(index<m) {
            			a[now][0] = index;
            			a[now][1] = b[index++];
        			}
        		}
        		
        		a[now][1] = a[now][1]/2;
        		
        		now++;
        		if(now==n) now = 0;
        		if(count==m) break;
        	}
        	
        	
        	sb.append("#"+t+" "+last+"\n");
        }
        
	    System.out.print(sb);
	}
}
