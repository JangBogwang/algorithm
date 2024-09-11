import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1255_암호생성기 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++)
        {
            int b = Integer.parseInt(br.readLine());
        	String[] str = br.readLine().split(" ");
        	int[] a = new int[8];
        	int min = Integer.MAX_VALUE;
        	for(int i = 0; i<8; i++) {
        		a[i] = Integer.parseInt(str[i]);
        		if(min>a[i]) min = a[i];
        	}
        	
        	int c = min/15;
        	if(c>0) c = c-1;
        	else c = 0;
        	
        	for(int i = 0; i<8; i++) a[i] = a[i] - c*15;
        	
        	int n=0;
        	int count=1;
        	while(true) {
        		a[n] -= count++;
        		if(a[n]<=0) {
        			a[n] = 0; 
        			break;
        		}
        		else {
        			n++;
        			if(n==8) n = 0;
        		}
        		if(count==6) count=1;
        	}
        	
        	n = n+1;
        	if(n == 8) n = 0;
        	
        	sb.append("#"+b+" ");
        	for(int i = 0; i<8; i++) {
        		sb.append(a[n++]+" ");
        		if(n==8) n = 0;
        	}
        	sb.append("\n");
        }
        
	    System.out.print(sb);
	}
}


