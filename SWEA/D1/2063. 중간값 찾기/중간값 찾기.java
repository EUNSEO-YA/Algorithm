import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        System.out.println(num[N/2]);
    }
}
