import java.util.Arrays;

public class netperm2 {

    static int[] p = {1, 2, 3, 5, 4}; // 초기 순열
    static int n, count;

    public static void main(String[] args) {

        n = p.length; // 배열의 길이
        count = 0; // 순열 개수 초기화

        do {
            count++;
            System.out.println(Arrays.toString(p)); // 현재 순열 출력

        } while (nextperm(n - 1)); // 다음 순열이 존재하면 반복
        System.out.println(count); // 총 생성된 순열 개수 출력
    }
    
    static boolean nextperm(int size) {
        
        // 1. 꼭대기 찾기 (오르막길 끝)
        int i = size;
        while (i > 0 && p[i - 1] >= p[i]) {
            i--;
        }
        if (i == 0) { // 더 이상의 순열이 없으면 false 반환
            return false;
        }
        
        // 2. 꼭대기 왼쪽 원소와 교환할 원소 찾기
        int j = size;
        while (p[i - 1] >= p[j]) {
            j--;
        }
        
        // 3. 두 원소 교환
        int t = p[i - 1];
        p[i - 1] = p[j];
        p[j] = t;
        
        // 4. 꼭대기 이후 원소들 뒤집기
        int k = size;
        while (i < k) {
            t = p[i];
            p[i] = p[k];
            p[k] = t;
            i++;
            k--;
        }
        
        return true; // 다음 순열 생성 성공
    }
}