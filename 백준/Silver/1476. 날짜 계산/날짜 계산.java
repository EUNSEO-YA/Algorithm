import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int year = 1;

        while(true) {
            int e = (year - 1) % 15 + 1;
            int s = (year - 1) % 28 + 1;
            int m = (year - 1) % 19 + 1;

            if(e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }
}