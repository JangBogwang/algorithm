package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea2383_점심식사시간 {
	static int min;
	static int n;
	static int[][] person;
	static int[][] stair;
	static int count; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			count = 0;
			int count2 = 0;
			person = new int[10][2];
			stair = new int[2][3];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a==1) {
						person[count][0] = i;
						person[count++][1] = j;
					}else if(a > 1) {
						stair[count2][0] = i;
						stair[count2][1] = j;
						stair[count2++][2] = a;
					}
				}
			}
			
			for(int i = 0; i < count; i++) {
				int x = person[i][0];
				int y = person[i][1];
				
				for(int j = 0; j < 2; j++) 
					person[i][j] = Math.abs(x - stair[j][0]) + Math.abs(y - stair[j][1]);
			}
			int[] s1 = new int[10];
			int[] s2 = new int[10];
			Arrays.fill(s1, Integer.MAX_VALUE);
			Arrays.fill(s2, Integer.MAX_VALUE);
			
			search(0, s1, s2, 0, 0);
			sb.append("#"+t+" "+(min-1)+"\n");
		}
		System.out.print(sb);
	}
	
	static void search(int now, int[] s1, int[] s2, int i1, int i2) {
		if(now < count) {
			s1[i1] = person[now][0];
			search(now+1, s1, s2, i1+1, i2);
			s1[i1] = Integer.MAX_VALUE;
			s2[i2] = person[now][1];
			search(now+1, s1, s2, i1, i2+1);
			s2[i2] = Integer.MAX_VALUE;
		}else {
			int[] s1c = new int[10];
			int[] s2c = new int[10];
			
			for(int i = 0; i <10; i++) {
				s1c[i] = s1[i];
				s2c[i] = s2[i];
			}
			
			Arrays.sort(s1c);
			Arrays.sort(s2c);
			
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			for(int i = 0; i < stair[0][2]; i++)
				q1.add(0);
			for(int i = 0; i < stair[1][2]; i++)
				q2.add(0);
			int num = 0, i1c = 0, i2c = 0, time = 1;
			int p1c = 0, p2c = 0;
			while(num < count) {
				int temp = q1.poll();
				num += temp;
				p1c -= temp;
				int temp2 = q2.poll();
				num += temp2;
				p2c -= temp2;
				int p1 = 0;
				while(s1c[i1c] < time && p1c < 3 && i1c < i1) {
					p1++;
					p1c++;
					i1c++;
				}
				
				q1.add(p1);
				int p2 = 0;
				while(s2c[i2c] < time && p2c < 3 && i2c < i2) {
					p2++;
					p2c++;
					i2c++;
				}
				q2.add(p2);
				time++;
			}
			if(time < min) min = time;
		}
	}
}
