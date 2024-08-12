import java.util.Arrays;

public class NetPerm {
	static int[] arr = {1, 2, 3, 4, 5, 6}; 
	static int length;
	static int k = 0;
	static int[][] arr3;
	
	public static void main(String[] args) {
		length = arr.length;
		boolean[] visited = new boolean[length];
		Arrays.sort(arr);
		int[] arr2 = new int[length];
		int[][] arr = new int[length][];
		np(visited, arr2,0);
	}
	
	public static void np(boolean[] visited, int[] arr2,int l) {
		if(l==visited.length) {
			return;
		}
		else {
			for(int i = 0; i < visited.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr2[l] = arr[i];
					np(visited,arr2,l+1 );
					visited[i] = false;
				}
			}
		}
	}
	
	public static int f(int n) {
		return n*f(n-1);
	}
}