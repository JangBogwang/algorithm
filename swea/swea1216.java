import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class swea1216 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for(int t = 1; t <=10; t++) {
            int n = Integer.parseInt(br.readLine()); 
            int result = 0;
             
            char[][] arr = new char[100][100];
            for(int i=0; i<100; i++) {
                String str = br.readLine();
                for(int j = 0; j<100; j++) arr[i][j] = str.charAt(j);
            }
            result = f(arr);
            sb.append("#"+n+" "+result+"\n");
        }
        System.out.print(sb);
    }
     
    public static int f(char[][] arr) {
        for(int l = 100; l>0; l-- ) {
            for(int i = 0; i< 100; i++) {
                for(int j = l-1;j < 100; j++) {
                    boolean check1 = true, check2 = true;
                    for(int k = 0; k<l/2; k++) {
                        if(arr[i][j-k]!=arr[i][j-l+1+k]) {
                            check1 = false;
                            break;
                        }
                    }
                    if(check1) return l;
                    for(int k = 0; k<l/2; k++) {
                        if(arr[j-k][i]!=arr[j-l+1+k][i]) {
                            check2 = false;
                            break;
                        }
                    }
                    if(check2) return l;
                }
            }
        }
        return 1;
    }
}