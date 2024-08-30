package algorithm;

public class BOJ4673_셀프넘버 {
	static boolean[] visited = new boolean[10001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		for(int i = 1; i <= 10000; i++) {
			if(!visited[i]) d(i, true);
		}
		
		System.out.print(sb);
	}
	
	public static void d(int n, boolean c) {
		if(c) sb.append(n+"\n");
		int temp = n;
		while(n > 0) {
			temp += n % 10;
			n = n/10;
		}
		if(temp <= 10000) {
			visited[temp] = true;
			d(temp, false);	
		}
	}
}
