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

        Arrays.sort(list);

        if(list.length == 1) {
            answer = list[0] * list[0];
        } else {
            answer = list[list.length - 1] * list[0];
        }

        System.out.println(answer);
    }
}