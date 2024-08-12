import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class swea8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Character, Character> m = new HashMap<>();
		m.put('>','<');
		m.put(')','(');
		m.put('}','{');
		m.put(']','[');
		
		for(int t = 1; t <= 10; t++) {
			Stack<Character> s = new Stack<>();
			int k = Integer.parseInt(br.readLine());
			int result = 1;
			String str = br.readLine();
			for(int i = 0; i < k; i++) {
				char a = str.charAt(i);
				if(a=='>'||a==')'||a==']'||a=='}') {
					if(s.pop()!=m.get(a)) {
						result = 0;
						break;
					}
				}
				else s.push(a);
			}
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
