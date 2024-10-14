package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17387_선분교차 {
	static class point{
		long x;
		long y;
		
		point(){
			super();
		}
		
		point(long x, long y){
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 1;
		point p1 = new point();
		point p2 = new point();
		point p3 = new point();
		point p4 = new point();
		st = new StringTokenizer(br.readLine());
		p1.x = Long.parseLong(st.nextToken());
		p1.y = Long.parseLong(st.nextToken());           
		p2.x = Long.parseLong(st.nextToken());
		p2.y = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		p3.x = Long.parseLong(st.nextToken());
		p3.y = Long.parseLong(st.nextToken());
		p4.x = Long.parseLong(st.nextToken());
		p4.y = Long.parseLong(st.nextToken());
		
		 long ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
	     long ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		
		if(ccw1==0l && ccw2 == 0l) {
			if (Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x)
				    && Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)) {
				    result = 1;  // 교차함
				}else {
					result = 0;
				}

		}else if(ccw1 <= 0 && ccw2 <= 0)
			result = 1;
		else result = 0;
		System.out.print(result);
	}
	
	static long ccw(point p1, point p2, point p3) {
		long ccw = (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x-p1.x);
		return Long.compare(ccw, 0);
	}
}
