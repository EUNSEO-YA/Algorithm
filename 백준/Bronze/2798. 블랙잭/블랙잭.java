import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // 카드의 합이 M을 넘지 않으면서 M과 최대한 가깝게
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        int sum = 0;
        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    int total = num[i] + num[j] + num[k];
                    if(M - total < 0) continue;
                    if(M - total >= 0) {
                        if(M - total < M - sum) {
                            answer = total;
                            sum = total;
                        } else {
                            answer = sum;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}