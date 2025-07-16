import java.util.Scanner;
    
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] bingo = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        int[] say = new int[25];
        for(int i = 0; i < 25; i++) {
            say[i] = sc.nextInt();
        }

        for(int cnt = 0; cnt < 25; cnt++) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(bingo[i][j] == say[cnt]) bingo[i][j] = 0;
                }
            }

            int check = 0;

            for(int i = 0; i < 5; i++) {
                int line = 0;
                for(int j = 0; j < 5; j++) {
                    if(bingo[i][j] == 0) line++;
                }
                if(line == 5) check++;
            }

            for(int i = 0; i < 5; i++) {
                int line = 0;
                for(int j = 0; j < 5; j++) {
                    if(bingo[j][i] == 0) line++;
                }
                if(line == 5) check++;
            }

            int line1 = 0;
            for(int i = 0; i < 5; i++) {
                if(bingo[i][i] == 0) line1++;
            }
            if(line1 == 5) check++;

            int line2 = 0;
            for(int i = 0; i < 5; i++) {
                if(bingo[i][4 - i] == 0) line2++;
            }
            if(line2 == 5) check++;

            if(check >= 3) {
                System.out.println(cnt + 1);
                break;
            }
        }
    }
}