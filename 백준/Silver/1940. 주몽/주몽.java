import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] list = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(list[i] + list[j] == M) count++;
            }
        }

        System.out.println(count);
    }
}