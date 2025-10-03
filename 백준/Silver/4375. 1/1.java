import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n은 2와 5로 나누어 떨어지지 않는다 (n <= 10000)
        // n의 배수 중 각 자릿수가 모두 1로만 이루어진 배수를 찾는다
        // 그 배수들 중 가장 작은 수가 몇 자리로 이루어져 있는지 출력한다

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            
            int num = 1 % n;
            int count = 1;
            
            while(num != 0) {
                num = (num * 10 + 1) % n;
                count++;
            }

            System.out.println(count);
        }
    }
}