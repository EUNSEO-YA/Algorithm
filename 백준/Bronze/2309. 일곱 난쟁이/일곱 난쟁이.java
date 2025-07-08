import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9];
        int[] answer = new int[7];
        int sum = 0;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        boolean found = false;

        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if( (arr[i] + arr[j] == sum - 100) ) {
                    int idx = 0;

                    for(int k = 0; k < 9; k++) {
                        if( k != i && k != j) {
                            answer[idx++] = arr[k];
                        }
                    }
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        
        Arrays.sort(answer);
        for(int i: answer) {
            System.out.println(i);
        }

    }
}