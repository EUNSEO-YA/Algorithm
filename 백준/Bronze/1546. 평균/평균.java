import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];

        for(int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);
        int M = score[N - 1];
        double sum = 0;
        double answer = 0;

        for(int i = 0; i < N; i++) {
            sum += score[i];
        }

        sum = sum / M * 100;
        answer = sum / N;

        System.out.println(answer);
    }
}