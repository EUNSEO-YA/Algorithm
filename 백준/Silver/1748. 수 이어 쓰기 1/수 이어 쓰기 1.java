import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int len = 1;
        int start = 1;

        while(start <= N) {
            int end = start * 10 - 1;

            if(end > N) end = N;

            count += (long)(end - start + 1) * len;

            start *= 10;
            len++;
        }

        System.out.println(count);
    }
}