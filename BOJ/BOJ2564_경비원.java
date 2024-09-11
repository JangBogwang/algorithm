import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리: 14164kb 시간: 120ms

// 핵심 아이디어. 각 위치를 사각형 둘레가 아닌 일직선 상에 존재한다고 가정하고 거리를 계산
// 박스라고 생각하면 박스를 뜯어서 펼쳐놓는다라는 느낌 
public class BOJ2564_경비원 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		// 최대 둘레 길이 구하기 
		int max = 2*(n+m);
		int t = Integer.parseInt(br.readLine());
		int[] a  = new int[t+1];
		
		// 위치를 변환하여 새로 할당 
		for(int i = 0; i < t+1; i++) {
			String[] str2 = br.readLine().split(" ");
			int b = Integer.parseInt(str2[1]);
			if(str2[0].equals("1")) a[i] = b;
			else if(str2[0].equals("2")) a[i] = 2*n+m - b;
			if(str2[0].equals("3")) a[i] = max - b;
			if(str2[0].equals("4")) a[i] = n+b;
		}
		
		//동근이와 위치 비교 동근이의 위치는 a[t]에 저장되어 있다. 
		int sum = 0;// 결과 
		for(int i = 0; i < t; i++) {
			int b1 = 0, b2 = 0;
			if(a[i] < a[t]) {
				//왼쪽 오른쪽 거리 저장
				b1 = a[t] - a[i];
				b2 = max - a[t] + a[i];
			}
			else {
				//왼쪽 오른쪽 거리 저장
				b1 = a[i] - a[t];
				b2 = max - a[i] + a[t];
			}
			//두 거리 비교 후 짧은 거리를 결과애 더해준다. 
			if(b1 > b2) sum += b2;
			else sum+=b1;
		}
		System.out.print(sum);
	} 
}



