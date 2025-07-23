import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (T-- > 0) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            int wormCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        wormCount++;

                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int cy = cur[0];
                            int cx = cur[1];

                            for (int d = 0; d < 4; d++) {
                                int ny = cy + dy[d];
                                int nx = cx + dx[d];

                                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                        visited[ny][nx] = true;
                                        q.offer(new int[]{ny, nx});
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(wormCount);
        }
    }
}