import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = sc.next().split("");

        int answer = 0;

        for(String s: str) {
            answer += Integer.valueOf(s);
        }

        System.out.println(answer);
    }
}