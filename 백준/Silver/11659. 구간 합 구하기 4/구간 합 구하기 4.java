import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        for(int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(prefixSum[j] - prefixSum[i - 1]);
        }
    }
}