import java.io.IOException;


public class BOJ3665_최종순위 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int T = readInt();
		int[] arr, parent, p;
		for(int t = 1; t <= T; t++) {
			int n = readInt();
			arr = new int[n];
			parent = new int[n+1];
			p = new int[n+1];
			
			for(int i = 0; i < n; i++) { 
				arr[i] = readInt();
				parent[arr[i]] = i;
			}
			
			for(int i = 1; i <= n; i++) p[i] = parent[i];
			
			int m = readInt();
			int a, b;
			for(int i = 0; i < m; i++) {
				a = readInt();
				b = readInt();
				
				if(parent[a] > parent[b]) {
					p[a]--;
					p[b]++;
				}else {
					p[a]++;
					p[b]--;
				}
			}
			
			boolean check = false;
			int[] map = new int[n];
			for(int i = 1; i <= n; i++){
				int next = p[i];
				if(next < 0|| next >= n ||map[next]!=0) {
					check = true;
					break;
				}else map[next] = i;
			}
			
			if(check)
				sb.append("IMPOSSIBLE\n");
			else {
				for(int i = 0; i < n; i++) sb.append(map[i]).append(" ");
				sb.append("\n");
			}
			
		}
		System.out.print(sb);
	}
	
    static int readInt() throws IOException {
        int result = 0;
        int read = System.in.read();
        while (read < '0' || read > '9')
            read = System.in.read();
        while (read >= '0' && read <= '9') {
            result = result * 10 + read - '0';
            read = System.in.read();
        }
        return result;
    }
}
