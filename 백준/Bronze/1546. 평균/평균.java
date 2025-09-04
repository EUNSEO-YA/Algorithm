import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];

        double sum = 0;
        double avg = 0;

        for(int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);
        int max = score[n - 1];

        for(int i = 0; i < n; i++) {
            sum += score[i];
        }

        sum = sum / max * 100;
        avg = sum / n;

        System.out.println(avg);
    }
}