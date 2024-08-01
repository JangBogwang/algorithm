import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ14499 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(); 
		
		int[] input = new int[5];
		int[] dice = {0,0,0,0,0,0,0};
		int[] now = {input[2], input[3]};
		
		Map<Integer, int[]> dice_roll = new HashMap<>();
		
		dice_roll.put(1,new int[] {5,4,2,3});
		dice_roll.put(2,new int[] {1,4,6,3});
		dice_roll.put(3,new int[] {5,1,2,6});
		dice_roll.put(4,new int[] {5,6,2,1});
		dice_roll.put(5,new int[] {6,4,1,3});
		dice_roll.put(6,new int[] {2,4,5,3});
		
		for(int i = 0; i < 5; i++) input[i] = Integer.parseInt(str.split(" ")[i]);
		
		int[][] arr = new int[input[0]][input[1]];
		
		for(int i = 0; i < input[0]; i++) {
			String[] str2 = br.readLine().split(" ");
			for(int j = 0; j < input[1]; j++) arr[i][j] = Integer.parseInt(str2[j]);
		}
		
		int top = 0;
		int now_dice = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < input[4]; i++) {
			int a = Integer.parseInt(st.nextToken());
			int[] t_arr = dice_roll.get(now_dice);
			int temp = -1; 
			
			if(a == 1) {
				now[1]++;
				if(now[1]==input[1]) {
					now[1]--;
					continue;
				}
				temp = t_arr[(top+1)%4];
				int b = index(dice_roll.get(temp), now_dice);
				top = (b+1)%4;				
			}
			else if(a == 2) {
				now[1]--;
				if(now[1]<0) {
					now[1]++;
					continue;
				}
				temp = t_arr[(top+3)%4];
				int b = index(dice_roll.get(temp), now_dice);
				top = (b+3)%4;
			}
			else if(a == 3) {
				now[0]--;
				if(now[0]<0) {
					now[0]++;
					continue;
				}
				temp = t_arr[top];
				int b = index(dice_roll.get(temp), now_dice);
				top = (b+2)%4;				
			}
			else if(a == 4) {
				now[0]++;
				if(now[0]==input[0]) {
					now[0]--;
					continue;
				}
				temp = t_arr[(top+2)%4];
				int b = index(dice_roll.get(temp), now_dice);
				top = b;
			}
			now_dice = temp;
			if(arr[now[0]][now[1]]==0) arr[now[0]][now[1]] = dice[now_dice]; 
			else {
				dice[now_dice] = arr[now[0]][now[1]];
				arr[now[0]][now[1]] = 0;
			}
			
			sb.append(dice[7-now_dice]+"\n");
		}
		System.out.print(sb);
		
	}
	
	public static int index(int[] arr, int n) {
		for(int i = 0; i < 4; i++) {
			if(arr[i]==n) return i;
		}
		return -1;
	}
}
