import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for(int row = 0; row <= N - 8; row++) {
            for(int col = 0; col <= M - 8; col++) {
                int whiteStart = 0;
                int blackStart = 0;

                for(int i = 0; i < 8; i++) {
                    for(int j = 0; j < 8; j++) {
                        char now = board[row + i][col + j];

                        if( (i + j) % 2 == 0 ) {
                            if(now != 'W') whiteStart++;
                            if(now != 'B') blackStart++;
                        } else {
                            if(now != 'B') whiteStart++;
                            if(now != 'W') blackStart++;
                        }
                    }
                }
                min = Math.min(min, Math.min(whiteStart, blackStart));
            }
        }
        System.out.println(min);
    }
}