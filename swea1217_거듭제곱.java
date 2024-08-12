import java.util.Scanner;

class swea1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		StringBuilder s = new StringBuilder();
		for(int t = 1; t<= 10; t++) {
			int n = c.nextInt();
			int a = c.nextInt();
			int b = c.nextInt();
			s.append("#"+n+" "+m(a,b)+"\n");
		}
		System.out.print(s);
	}
	
	static int m(int n, int l) {
		if(l==1) return n;
		else return n*m(n,l-1);
	}
}
