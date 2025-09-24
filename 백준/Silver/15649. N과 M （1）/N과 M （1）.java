import java.util.*;

class Main {
    static int n, m;
    static boolean[] visited;
    static int[] result;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        result = new int[m];

        dfs(0);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}