import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int MAX = 1000001;
        boolean[] visited = new boolean[MAX];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            if(pos == K){
                System.out.println(time);
                break;
            }

            int[] nextPos = {pos - 1, pos + 1, pos * 2};
            for(int next: nextPos) {
                if(next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
    }
}