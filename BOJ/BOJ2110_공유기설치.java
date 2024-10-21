import java.util.Arrays;
import java.util.Scanner;

public class BOJ2110_공유기설치 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 집의 개수
        int C = sc.nextInt(); // 공유기의 개수
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }

        // 집의 좌표를 정렬
        Arrays.sort(houses);

        // 이분 탐색 범위 설정
        int start = 1; // 최소 거리
        int end = houses[N - 1] - houses[0]; // 최대 거리
        int result = 0;

        // 이분 탐색
        while (start <= end) {
            int mid = (start + end) / 2; // 두 공유기 사이의 거리

            if (canInstall(houses, N, C, mid)) {
                // 공유기를 mid 거리로 설치 가능하다면, 더 큰 거리를 시도
                result = mid;
                start = mid + 1;
            } else {
                // 설치가 불가능하면 거리를 줄여서 다시 시도
                end = mid - 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // 공유기 설치가 가능한지 확인하는 함수
    public static boolean canInstall(int[] houses, int N, int C, int distance) {
        // 첫 번째 집에 공유기 설치
        int count = 1; // 설치한 공유기의 개수
        int lastPosition = houses[0]; // 마지막으로 공유기가 설치된 위치

        for (int i = 1; i < N; i++) {
            if (houses[i] - lastPosition >= distance) {
                count++;
                lastPosition = houses[i]; // 공유기 설치
            }
            if (count >= C) {
                return true; // 공유기 C개 이상 설치 가능
            }
        }

        return false; // 공유기 C개 설치 불가능
    }
}
