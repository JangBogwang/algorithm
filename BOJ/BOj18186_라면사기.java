import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOj18186_라면사기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		long[] arr = new long[n+2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		long result = 0;
		if(b <= c) {
			for(int i = 0; i < n; i++) 
				result += b * arr[i];
		}else {
			for(int i = 0; i < n; i++) {
				if(arr[i+1] > arr[i+2]) {
					long min  = Math.min(arr[i], arr[i+1] - arr[i+2]);
					result += min*(b+c);
					arr[i] -= min;
					arr[i+1] -= min;
					
					min = mins(arr[i], arr[i+1], arr[i+2]);
					result+= min*(b + c + c);
					arr[i]-=min;
					arr[i+1]-=min;
					arr[i+2]-=min;
				}else {
					long min = mins(arr[i], arr[i+1], arr[i+2]);
					result+= min*(b + c + c);
					arr[i]-=min;
					arr[i+1]-=min;
					arr[i+2]-=min;
				
					min = Math.min(arr[i], arr[i+1]);
					result+= min*(b + c);
					arr[i]-=min;
					arr[i+1]-=min;
				}
				result+= b * arr[i];
				arr[i] = 0;
			}
		}
		
		System.out.print(result);
		
	}
	
	static long mins(long a, long b, long c) {
		long mv = Integer.MAX_VALUE;
		if(mv > a)
			mv = a;
		if(mv > b)
			mv = b;
		if(mv > c)
			mv = c;
		
		return mv;
	}
}
