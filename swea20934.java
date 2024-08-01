import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea20934 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int result;
         
        for(int x = 1; x <= t; x++)
        {
            int a=0;
        	float[] arr = new float[3];
            String str = br.readLine();
            for(int i = 0; i<3; i++) {
            	if(str.charAt(i)=='o') {
            		arr[i] = 1;
            		a = i;
            	}
            }
            int n = Integer.parseInt(str.substring(4));

        	result = 0;
        	if(a==2&&n == 0) result = 2;
        	else if(a==1 &&(n&1)==0 ) result = 1;
        	else if(a!=1 &&(n&1)==1 ) result = 1;

            sb.append("#"+x+" "+ result +"\n");
        }
        System.out.print(sb);
    }
}
