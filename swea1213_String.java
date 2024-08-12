import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1213_String {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] str1 = br.readLine().split("");
			String[] str2 = br.readLine().split("");
			int size1 = str1.length;
			int size2 = str2.length;
			
			int count = 0;
			
			for(int i = 0; i<=size2-size1;i++) {
				if(str2[i].equals(str1[0])){
					boolean check = true;
					for(int j = 1; j<size1; j++) {
						if(!str2[i+j].equals(str1[j])) check = false;
					}
					if(check) count++;
				}
			}
			sb.append("#"+n+" "+count+"\n");
		}
		System.out.print(sb);
	}
}
