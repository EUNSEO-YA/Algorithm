import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] T = new int[N];
        int[] P = new int[N];
        
        for(int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int[] dp = new int[N+1];

        for(int i = N-1; i >= 0; i--) {
            if(i + T[i] <= N) {
                dp[i] = Math.max(dp[i + T[i]] + P[i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}