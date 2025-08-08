import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] h = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            h[i] = sc.nextInt();
            sum += h[i];
        }

        int gap = sum - 100;

        Arrays.sort(h);
        boolean found = false;
        
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(h[i] + h[j] == gap) {
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        else {
                            System.out.println(h[k]);
                        }
                    }
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
    }
}