import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] list = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        for(int k = 0; k < N; k++) {
             for(int i = 0; i < N; i++) {
                if (list[i][k] == 0) continue;
                for(int j = 0; j < N; j++) {
                    if(list[k][j] == 1) {
                        list[i][j] = 1;
                    }
                }
            }   
        }

        for(int i = 0; i < N; i++) {
          for(int j = 0; j < N; j++) {
              System.out.print(list[i][j] + " ");
          }
          System.out.println();
      }
    }
}