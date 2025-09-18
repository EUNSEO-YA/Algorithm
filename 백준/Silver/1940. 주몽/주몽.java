import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;
        int start = 1;
        int end = 1;

        int[] num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(num[i] + num[j] == M) count++;
            }
        }

        System.out.println(count);
    }
}