import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = sc.next().split("");

        int answer = 0;

        for(int i = 0; i < N; i++) {
            answer += Integer.valueOf(str[i]);
        }

        System.out.println(answer);
    }
}