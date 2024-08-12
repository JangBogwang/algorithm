import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea3499_퍼펙트셔플 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++)
        {
        	int l = Integer.parseInt(br.readLine());
        	String[] str = br.readLine().split(" ");
        	int x = 0;
        	sb.append("#"+t+" ");
        	if((l&1)==1) x = 1;
        	for(int i = 0; i < l/2; i++) {
        		sb.append(str[i]+" ");
        		sb.append(str[l/2+i+x]+" ");
        	}
        	if(x==1) sb.append(str[l/2]);
        	sb.append("\n");
        }
        
	    System.out.print(sb);
	}
}
