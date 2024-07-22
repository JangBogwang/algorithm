import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class swea2056
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for(int x = 1; x <= t; x++)
        {
            int[] md = {31,28,31,30,31,30,31,31,30,31,30,31};
            String ymd = br.readLine();
            int m = Integer.parseInt(ymd.substring(4,6));
            int d = Integer.parseInt(ymd.substring(6));
            String result = "-1"; 
            if(0<m&&12>=m){
                if(md[m-1]>=d){
                    result = ymd.substring(0,4)+"/"+ymd.substring(4,6)+"/"+ymd.substring(6);
                }
            }
           sb.append("#"+x+" "+result+"\n");
        }
        System.out.print(sb);
    }
}
