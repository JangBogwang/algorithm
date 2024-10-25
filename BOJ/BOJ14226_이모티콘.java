import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14226_이모티콘 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		
		int[] mind = new int[1101];
		Arrays.fill(mind, Integer.MAX_VALUE);
		mind[1] = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0]==s) {
				break;
			}
			if(now[1]!=0&& now[0]+now[1]<=s+100&&mind[now[0]+now[1]] > now[2]-1) {
				q.add(new int[] {now[1]+now[0], now[1], now[2]+1});
				if(mind[now[0]+now[1]] > now[2]+1) {
					mind[now[1]+now[0]] = now[2]+1;
				}
			}
			  
			if(now[1] < now[0]) {
				q.add(new int[] {now[0], now[0], now[2]+1});
			}
			
			if(now[0] > 1) {
				q.add(new int[] {now[0]-1, now[1], now[2]+1});
				if(mind[now[0]-1] > now[2]+1)
					mind[now[0]-1] = now[2]+1;
			}
		}
		
		System.out.print(mind[s]);
	}
}
