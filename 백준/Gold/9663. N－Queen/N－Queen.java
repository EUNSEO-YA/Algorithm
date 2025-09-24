import java.util.*;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || diag1[row + i] || diag2[row - i + N - 1]) continue;

            col[i] = true;
            diag1[row + i] = true;
            diag2[row - i + N - 1] = true;

            dfs(row + 1);

            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + N - 1] = false;
        }
    }
}