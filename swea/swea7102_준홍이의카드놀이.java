import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea7102_준홍이의카드놀이 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int result;
         
        for(int t = 1; t <= T; t++)
        {
        	String[] str = br.readLine().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	
        	if(m<n) {
        		int s = n;
        		n = m;
        		m = s;
        	}
        	
        	sb.append("#"+t+" ");
        	for(int i = n+1; i <= m+1; i++) sb.append(i+" ");
        	sb.append("\n");
        }
        
	    System.out.print(sb);
	}
}
