import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea1224_계산기3 {
    private static int precedence(char op) {
        switch (op) {
            case '+':
                return 1;
            case '*':
                return 2;
            default:
                return -1;
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String infix = str;
			
			Stack<Character> result = new Stack<>();
	        Stack<Character> stack = new Stack<>();
	        Stack<Integer> c2 = new Stack<>();

	        for (int i = 0; i < infix.length(); i++) {
	            char c = infix.charAt(i);

	            if (Character.isDigit(c)) result.push(c);
	            else if (c == '(') stack.push(c);
	            else if (c == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(') result.push(stack.pop());
	                stack.pop(); 
	            }
	            else {
	                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
	                    result.push(stack.pop());
	                }
	                stack.push(c);
	            }
	        }
	        
	        while (!stack.isEmpty()) result.push(stack.pop());
	        
	        char[] c1 = new char[result.size()];
	        for(int i = result.size()-1; i>-1; i--) c1[i] = result.pop();
	        
			for(int i = 0; i<c1.length; i++) {
				if(c1[i]=='+'||c1[i]=='*') {
					int a = c2.pop();
					int b = c2.pop();
					if(c1[i]=='+') c2.push(a+b);
					else c2.push(a*b);
				}
				else {
					int a = c1[i]-'0';
					c2.push(a);
				}
			}
			
			sb.append("#"+t+" "+c2.pop()+"\n");
		}
		System.out.print(sb);
	}
}