import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] S = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[N];
        int[] min = {Integer.MAX_VALUE};

        dfs(0, 0, visited, S, N, min);

        System.out.println(min[0]);
    }

    public static void dfs(int idx, int depth, boolean[] visited, int[][] S, int N, int[] min) {
        if (depth == N / 2) {
            int start = 0, link = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        start += S[i][j] + S[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += S[i][j] + S[j][i];
                    }
                }
            }

            int diff = Math.abs(start - link);
            if (diff == 0) {
                System.out.println(0);
                System.exit(0);
            }
            min[0] = Math.min(min[0], diff);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, visited, S, N, min);
                visited[i] = false;
            }
        }
    }
}