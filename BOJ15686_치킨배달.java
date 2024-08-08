package algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686_치킨배달 {
	static int n, m;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static int min_distance;
	static boolean[] checked;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) chicken.add(new Point(i,j));
				if(arr[i][j]==1) house.add(new Point(i, j));;
			}
		}
		
	
		checked = new boolean[chicken.size()];
		min_distance = Integer.MAX_VALUE;
		combination(0, 0);
		
		System.out.print(min_distance);
	}
	
	public static void combination(int now, int length) {
		if(length==m) {
			distance_check();
		}
		for(int i = now; i < chicken.size(); i++) {
			if(!checked[i]) {
				checked[i] = true;
				combination(i+1, length+1);
				checked[i] = false;
			}
		}
		
	}
	
	public static void distance_check() {
		int sum_distance = 0;
		for(Point x: house) {
			int min = Integer.MAX_VALUE; 
			for(int i = 0; i < chicken.size(); i++) {
				if(checked[i]) {
					Point t = chicken.get(i);
					int d = Math.abs(t.x - x.x)+Math.abs(t.y - x.y);
					if(d<min) min = d; 
				}
			}
			sum_distance += min;
		}
		if(min_distance>sum_distance) min_distance = sum_distance;
	}

}
