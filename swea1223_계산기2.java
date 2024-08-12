import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea1223_계산기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] c = str.toCharArray();
			
			Stack<Integer> c1 = new Stack<>();
			Stack<Character> c2 = new Stack<>();
			c2.push(c[0]);
			
			for(int i = 1; i<n; i +=2) {
				if(c[i]=='+') {
					c2.push(c[i+1]);
					c2.push(c[i]);
				}
				else if(c[i]=='*') {
					char a = c2.pop();
					if(a=='+') {
						c2.push(c[i+1]);
						c2.push(c[i]);
						c2.push('+');
					}
					else {
						c2.push(a);
						c2.push(c[i+1]);
						c2.push(c[i]);
					}
				}
			}
			
			for(int i = n-1; i >-1; i--) c[i] = c2.pop();
			for(int i = 0; i<n; i++) {
				if(c[i]=='+'||c[i]=='*') {
					int a = c1.pop();
					int b = c1.pop();
					if(c[i]=='+') c1.push(a+b);
					else c1.push(a*b);
				}
				else {
					int a = c[i]-'0';
					c1.push(a);
				}
			}
			
			sb.append("#"+t+" "+c1.pop()+"\n");
		}
		System.out.print(sb);
	}
}
