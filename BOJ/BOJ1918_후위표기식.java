package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918_후위표기식 {
	static int order(char c) {
		switch(c) {
			case '+': 
				return 1;
			case '-':
				return 1;
			case '*':
				return 2;
			case '/':
				return 2;
			default:
				return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cal = br.readLine().toCharArray();
		Stack<Character> result = new Stack<>(); 
		Stack<Character> stack = new Stack<>();
		String str = "";
		for(int i = 0; i < cal.length; i++) {
			char temp = cal[i];
			if(order(temp)==-1 && temp != '(' && temp != ')') 
				result.add(temp);
			else if(temp=='(') {
				stack.add(temp);
			}else if(temp == ')') {
				while(!stack.isEmpty() &&stack.peek()!='(') {
					result.add(stack.pop());
				}
				stack.pop();
			}else {
				while(!stack.isEmpty() &&order(stack.peek()) >= order(temp)) {
					result.add(stack.pop());
				}
				stack.add(temp);
			}
		}
		
		while(!stack.isEmpty()) result.push(stack.pop());
		
		while(!result.isEmpty()) str = result.pop() + str;	
		System.out.print(str);
	}
}
