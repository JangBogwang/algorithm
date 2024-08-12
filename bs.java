import java.util.Arrays;

public class bs {
	static int[] p= {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		Arrays.sort(p);
		int il = bsf(0, p.length, 6);
		System.out.print(il);
	}
	
	public static int bsf(int s, int e, int t) {
		int m = (s+e)/2;
		if(p[m]>t) return bsf(s, m-1, t);
		else if(p[m]<t) return bsf(m+1, e, t);
		else return m;
	}
}
