import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ16566_카드게임 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cards = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int query = Integer.parseInt(st.nextToken());
            int index = findNext(cards, query);
            sb.append(cards[index]).append("\n");
            if (index + 1 < parent.length) {
                union(index, index + 1); // 사용한 카드와 그 다음 카드 묶기
            }
        }

        System.out.print(sb);
    }

    static int findNext(int[] cards, int query) {
        int index = Arrays.binarySearch(cards, query);
        if (index < 0) {
            index = -(index + 1);
        } else {
            index++;
        }
        // 배열 범위를 벗어나지 않도록 체크
        if (index >= cards.length) {
            index = cards.length - 1;
        }
        return find(index);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}
