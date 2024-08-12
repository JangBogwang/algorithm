import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea1234_비밀번호 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			String[] str =br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			String[] str2 = str[1].split("");
			Stack<Integer> s = new Stack<>();
			int p = -1, p2 = -1;
			for(int i=0; i<n; i++) {
				p = Integer.parseInt(str2[i]);
				if(s.isEmpty()) s.push(p);
				else {
					p2 = s.pop();
					if(p!=p2) continue;
					else {
						s.push(p2);
						s.push(p);
					}
				}
			}
			
			int s_size = s.size();
			String result = "\n";
			for(int i = 0; i<s_size;i++) {
				result = s.pop()+result;
			}
			sb.append("#"+t+" "+result);
		}
		System.out.print(sb);
	}
}
