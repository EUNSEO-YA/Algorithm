import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int num = 1;

        System.out.print("1 ");
        for(int i = 1; i <= T; i++) {
            System.out.print(num * 2 + " ");
            num *= 2;
        }
    }
}