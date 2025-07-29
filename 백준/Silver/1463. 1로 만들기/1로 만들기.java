import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();

        visited[N] = true;
        queue.offer(new int[]{N, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int count = cur[1];

            if(now == 1) {
                System.out.println(count);
                return;
            }

            if(now % 3 == 0 && !visited[now / 3]) {
                visited[now / 3] = true;
                queue.offer(new int[]{now / 3, count + 1});
            }
            if(now % 2 == 0 && !visited[now / 2]) {
                visited[now / 2] = true;
                queue.offer(new int[]{now / 2, count + 1});
            }
            if(now - 1 >= 1 && !visited[now - 1]) {
                visited[now - 1] = true;
                queue.offer(new int[]{now - 1, count + 1});
            }
        }
    }
}