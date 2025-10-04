import java.util.*;

class Main {
    static int N;
    static int max;
    static char[][] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N * N 크기에 사탕을 채워 놓는다
        // 사탕 색이 다른, 인접한 두 칸을 골라 서로 교환한다
        // 같은 색으로 연결된 부분 길이를 고른다
        // 이 길이가 최대 얼마인가

        N = sc.nextInt();
        board = new char[N][N];
        
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1);
                }

                if(i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static void check() {
        for(int i = 0; i < N; i++){
            int rowCount = 1;
            int colCount = 1;
            
            for(int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else{
                    rowCount = 1;
                }
                max = Math.max(max, rowCount);

                if(board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else{
                    colCount = 1;
                }
                max = Math.max(max, colCount);
            }
        }
    }
}