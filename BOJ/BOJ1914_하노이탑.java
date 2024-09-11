import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class BOJ1914_하노이탑 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		BigInteger b = new BigInteger(n);
		
		BigInteger a = h(b);
		sb.append(a+"\n");
		int n2 = Integer.parseInt(n);
		if(n2<=20) hanoi(1,3,2,n2);
		System.out.print(sb);
	}
	
	public static BigInteger h(BigInteger n) {
		BigInteger t = new BigInteger("1");
		BigInteger t2 = new BigInteger("2");
		if(n.equals(t)) return new BigInteger("1");
		else return (h(n.subtract(t)).multiply(t2)).add(t);
	}
	
	public static void hanoi(int s, int e, int m, int n) {
		if(n==1) {
			sb.append(s+" "+e+"\n");
		}
		else{
			hanoi(s,m,e,n-1);
			sb.append(s+" "+e+"\n");
			hanoi(m,e,s,n-1);
		}
		
	}
}
