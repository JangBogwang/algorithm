import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15558_점프게임 {
 public static void main(String[] args) throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st = new StringTokenizer(br.readLine());
	 int n = Integer.parseInt(st.nextToken());
	 int k = Integer.parseInt(st.nextToken());
	 int result = 0;
	 
	 boolean[][] line = new boolean[n+1][2];
	 boolean[][] visited = new boolean[n+1][2];
	 
	 for(int i = 0; i < 2; i++) {
		 char[] a = br.readLine().toCharArray();
		 for(int j = 1; j <= n; j++) {
			 if(a[j-1]=='1') line[j][i] = true;
		 }
	 }
	 
	 Queue<int[]> q = new LinkedList<>();
	 q.add(new int[] {1, 0, 0});
	 visited[1][0] = true;
	 while(!q.isEmpty()) {
		 int[] now = q.poll();
		 int x = now[0];
		 int y = now[1];
		 int z = now[2];
		 if(now[0]+k > n) {
			 result = 1;
			 break;
		 }
		 
		 if(line[x+1][y]&&!visited[x+1][y]) {
			 q.add(new int[] {x+1, y, z+1});
			 visited[x+1][y] = true;
		 }
		 if(line[x-1][y]&&!visited[x-1][y]&&x-1 > z+1) {
			 q.add(new int[] {x-1, y, z+1});
			 visited[x-1][y] = true;
		 }
		 if(line[x+k][(y+1)%2]&&!visited[x+k][(y+1)%2]) {
			 q.add(new int[] {x+k, (y+1)%2, z+1});
			 visited[x+k][(y+1)%2] = true;
		 }
		 
	 }
	 System.out.print(result);
 }
}
