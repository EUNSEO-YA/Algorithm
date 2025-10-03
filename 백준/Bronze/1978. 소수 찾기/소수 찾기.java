import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        
        int N = sc.nextInt();
        int[] list = new int[N];
        
        for(int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int num = 0;
            if(list[i] == 1) continue;
            
            for(int j = 1; j <= list[i]; j++) {
                if(list[i] % j == 0) num++;
            }
            
            if(num <= 2) answer++;
        }

        System.out.println(answer);
    }
}