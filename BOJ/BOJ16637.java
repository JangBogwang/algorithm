import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16637 {
	static long max = Long.MIN_VALUE;
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];
		String st = br.readLine();
		for(int i = 0; i<n; i++) arr[i] = st.charAt(i);
		if(n==1) max = (int)arr[0]-'0';
		else re((int)arr[0]-'0',arr, 1,n-1);
		
		System.out.println(max);
	}
	
	public static void re(long previous, char[] arr, int now, int n) {
		long temp=0;
		int a = (int)arr[now+1]-'0';
		if(arr[now]=='*') temp = previous*a;
		else if(arr[now]=='+') temp = previous+a;
		else if(arr[now]=='-') temp = previous-a;
		
		if((n - now)==1) {
			if(max<temp) max = temp;
		}
		else{
			int b = (int)arr[now+3] -'0';
			int c = 0;
			if(arr[now+2]=='*')  c = a*b;
			else if(arr[now+2]=='+') c = a+b;
			else if(arr[now+2]=='-') c = a-b;
			if(arr[now]=='*') previous = previous*c;
			else if(arr[now]=='+') previous = previous+c;
			else if(arr[now]=='-') previous = previous-c;

			if((n-now)==3) {
				if(max<previous) max = previous;
			}
			else re(previous, arr, now+4,n);
			re(temp,arr,now+2,n);	 
		}
	}
}
