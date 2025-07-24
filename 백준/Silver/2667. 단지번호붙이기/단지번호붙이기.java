import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int total = 0;
        ArrayList<Integer> houseList = new ArrayList<>();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    total++;
                    int count = 0;

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    map[i][j] = 0;

                    while(!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        count++;

                        for(int d = 0; d < 4; d++) {
                            int ny = cur[0] + dy[d];
                            int nx = cur[1] + dx[d];

                            if(ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == 1) {
                                map[ny][nx] = 0;
                                stack.push(new int[]{ny, nx});
                            }
                        }
                    }
                    houseList.add(count);
                }
            }
        }
        Collections.sort(houseList);
        System.out.println(total);

        for(int h: houseList) {
            System.out.println(h);
        }
    }
}